
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
    <head>
        
        <title>Labs Page</title>
        
        <link href="assets/bootstrap.min.css" rel="stylesheet">
        <link href="assets/starter-template.css" rel="stylesheet">
        <script>
var DOM_a;

function tabberObj(argsObj)
{
  var arg; /* name of an argument to override */

  /* Element for the main tabber div. If you supply this in argsObj,
     then the init() method will be called.
  */
  this.div = null;

  /* Class of the main tabber div */
  this.classMain = "tabber";

  /* Rename classMain to classMainLive after tabifying
     (so a different style can be applied)
  */
  this.classMainLive = "tabberlive";

  /* Class of each DIV that contains a tab */
  this.classTab = "tabbertab";

  /* Class to indicate which tab should be active on startup */
  this.classTabDefault = "tabbertabdefault";

  /* Class for the navigation UL */
  this.classNav = "tabbernav";

  /* When a tab is to be hidden, instead of setting display='none', we
     set the class of the div to classTabHide. In your screen
     stylesheet you should set classTabHide to display:none.  In your
     print stylesheet you should set display:block to ensure that all
     the information is printed.
  */
  this.classTabHide = "tabbertabhide";

  /* Class to set the navigation LI when the tab is active, so you can
     use a different style on the active tab.
  */
  this.classNavActive = "tabberactive";

  /* Elements that might contain the title for the tab, only used if a
     title is not specified in the TITLE attribute of DIV classTab.
  */
  this.titleElements = ['h2','h3','h4','h5','h6'];

  /* Should we strip out the HTML from the innerHTML of the title elements?
     This should usually be true.
  */
  this.titleElementsStripHTML = true;

  /* If the user specified the tab names using a TITLE attribute on
     the DIV, then the browser will display a tooltip whenever the
     mouse is over the DIV. To prevent this tooltip, we can remove the
     TITLE attribute after getting the tab name.
  */
  this.removeTitle = true;

  /* If you want to add an id to each link set this to true */
  this.addLinkId = false;

  /* If addIds==true, then you can set a format for the ids.
     <tabberid> will be replaced with the id of the main tabber div.
     <tabnumberzero> will be replaced with the tab number
       (tab numbers starting at zero)
     <tabnumberone> will be replaced with the tab number
       (tab numbers starting at one)
     <tabtitle> will be replaced by the tab title
       (with all non-alphanumeric characters removed)
   */
  this.linkIdFormat = '<tabberid>nav<tabnumberone>';

  /* You can override the defaults listed above by passing in an object:
     var mytab = new tabber({property:value,property:value});
  */
  for (arg in argsObj) { this[arg] = argsObj[arg]; }

  /* Create regular expressions for the class names; Note: if you
     change the class names after a new object is created you must
     also change these regular expressions.
  */
  this.REclassMain = new RegExp('\\b' + this.classMain + '\\b', 'gi');
  this.REclassMainLive = new RegExp('\\b' + this.classMainLive + '\\b', 'gi');
  this.REclassTab = new RegExp('\\b' + this.classTab + '\\b', 'gi');
  this.REclassTabDefault = new RegExp('\\b' + this.classTabDefault + '\\b', 'gi');
  this.REclassTabHide = new RegExp('\\b' + this.classTabHide + '\\b', 'gi');

  /* Array of objects holding info about each tab */
  this.tabs = new Array();

  /* If the main tabber div was specified, call init() now */
  if (this.div) {

    this.init(this.div);

    /* We don't need the main div anymore, and to prevent a memory leak
       in IE, we must remove the circular reference between the div
       and the tabber object. */
    this.div = null;
  }
}


/*--------------------------------------------------
  Methods for tabberObj
  --------------------------------------------------*/


tabberObj.prototype.init = function(e)
{
  /* Set up the tabber interface.

     e = element (the main containing div)

     Example:
     init(document.getElementById('mytabberdiv'))
   */


  var
  childNodes, /* child nodes of the tabber div */
  i, i2, /* loop indices */
  t, /* object to store info about a single tab */
  defaultTab=0, /* which tab to select by default */
  DOM_ul, /* tabbernav list */
  DOM_li, /* tabbernav link */
  aId, /* A unique id for DOM_a */
  headingElement; /* searching for text to use in the tab */

  /* Verify that the browser supports DOM scripting */
  if (!document.getElementsByTagName) { return false; }

  /* If the main DIV has an ID then save it. */
  if (e.id) {
    this.id = e.id;
  }

  /* Clear the tabs array (but it should normally be empty) */
  this.tabs.length = 0;

  /* Loop through an array of all the child nodes within our tabber element. */
  childNodes = e.childNodes;
  for(i=0; i < childNodes.length; i++) {

    /* Find the nodes where class="tabbertab" */
    if(childNodes[i].className &&
       childNodes[i].className.match(this.REclassTab)) {
      
      /* Create a new object to save info about this tab */
      t = new Object();
      
      /* Save a pointer to the div for this tab */
      t.div = childNodes[i];
      t.id = childNodes[i].id;
      
      /* Add the new object to the array of tabs */
      this.tabs[this.tabs.length] = t;

      /* If the class name contains classTabDefault,
	 then select this tab by default.
      */
      if (childNodes[i].className.match(this.REclassTabDefault)) {
	defaultTab = this.tabs.length-1;
      }
    }
  }

  /* Create a new UL list to hold the tab headings */
  DOM_ul = document.createElement("ul");
  DOM_ul.className = this.classNav;
  
  /* Loop through each tab we found */
  for (i=0; i < this.tabs.length; i++) {

    t = this.tabs[i];

    /* Get the label to use for this tab:
       From the title attribute on the DIV,
       Or from one of the this.titleElements[] elements,
       Or use an automatically generated number.
     */
    t.headingText = t.div.title;

    /* Remove the title attribute to prevent a tooltip from appearing */
    if (this.removeTitle) { t.div.title = ''; }

    if (!t.headingText) {

      /* Title was not defined in the title of the DIV,
	 So try to get the title from an element within the DIV.
	 Go through the list of elements in this.titleElements
	 (typically heading elements ['h2','h3','h4'])
      */
      for (i2=0; i2<this.titleElements.length; i2++) {
	headingElement = t.div.getElementsByTagName(this.titleElements[i2])[0];
	if (headingElement) {
	  t.headingText = headingElement.innerHTML;
	  if (this.titleElementsStripHTML) {
	    t.headingText.replace(/<br>/gi," ");
	    t.headingText = t.headingText.replace(/<[^>]+>/g,"");
	  }
	  break;
	}
      }
    }

    if (!t.headingText) {
      /* Title was not found (or is blank) so automatically generate a
         number for the tab.
      */
      t.headingText = i + 1;
    }

    /* Create a list element for the tab */
    DOM_li = document.createElement("li");

    /* Save a reference to this list item so we can later change it to
       the "active" class */
    t.li = DOM_li;

    /* Create a link to activate the tab */
    DOM_a = document.createElement("a");
    DOM_a.appendChild(document.createTextNode(t.headingText));
    DOM_a.href = "/LADManagment/labs.jsp?lab="+t.id;
    DOM_a.title = t.headingText;
    DOM_a.onclick = this.navClick;

    /* Add some properties to the link so we can identify which tab
       was clicked. Later the navClick method will need this.
    */
    DOM_a.tabber = this;
    DOM_a.tabberIndex = i;

    /* Do we need to add an id to DOM_a? */
    if (this.addLinkId && this.linkIdFormat) {

      /* Determine the id name */
      aId = this.linkIdFormat;
      aId = aId.replace(/<tabberid>/gi, this.id);
      aId = aId.replace(/<tabnumberzero>/gi, i);
      aId = aId.replace(/<tabnumberone>/gi, i+1);
      aId = aId.replace(/<tabtitle>/gi, t.headingText.replace(/[^a-zA-Z0-9\-]/gi, ''));

      DOM_a.id = aId;
    }

    /* Add the link to the list element */
    DOM_li.appendChild(DOM_a);

    /* Add the list element to the list */
    DOM_ul.appendChild(DOM_li);
  }

  /* Add the UL list to the beginning of the tabber div */
  e.insertBefore(DOM_ul, e.firstChild);

  /* Make the tabber div "live" so different CSS can be applied */
  e.className = e.className.replace(this.REclassMain, this.classMainLive);

  /* Activate the default tab, and do not call the onclick handler */
  this.tabShow(defaultTab);

  /* If the user specified an onLoad function, call it now. */
  if (typeof this.onLoad == 'function') {
    this.onLoad({tabber:this});
  }

  return this;
};


tabberObj.prototype.navClick = function(event)
{
  /* This method should only be called by the onClick event of an <A>
     element, in which case we will determine which tab was clicked by
     examining a property that we previously attached to the <A>
     element.

     Since this was triggered from an onClick event, the variable
     "this" refers to the <A> element that triggered the onClick
     event (and not to the tabberObj).

     When tabberObj was initialized, we added some extra properties
     to the <A> element, for the purpose of retrieving them now. Get
     the tabberObj object, plus the tab number that was clicked.
  */

  var
  rVal, /* Return value from the user onclick function */
  a, /* element that triggered the onclick event */
  self, /* the tabber object */
  tabberIndex, /* index of the tab that triggered the event */
  onClickArgs; /* args to send the onclick function */

  a = this;
  if (!a.tabber) { return false; }

  self = a.tabber;
  tabberIndex = a.tabberIndex;

  /* Remove focus from the link because it looks ugly.
     I don't know if this is a good idea...
  */
  a.blur();

  /* If the user specified an onClick function, call it now.
     If the function returns false then do not continue.
  */
  if (typeof self.onClick == 'function') {

    onClickArgs = {'tabber':self, 'index':tabberIndex, 'event':event};

    /* IE uses a different way to access the event object */
    if (!event) { onClickArgs.event = window.event; }

    rVal = self.onClick(onClickArgs);
    if (rVal === false) { return false; }
  }

  self.tabShow(tabberIndex);

  return false;
};


tabberObj.prototype.tabHideAll = function()
{
  var i; /* counter */

  /* Hide all tabs and make all navigation links inactive */
  for (i = 0; i < this.tabs.length; i++) {
    this.tabHide(i);
  }
};


tabberObj.prototype.tabHide = function(tabberIndex)
{
  var div;

  if (!this.tabs[tabberIndex]) { return false; }

  /* Hide a single tab and make its navigation link inactive */
  div = this.tabs[tabberIndex].div;

  /* Hide the tab contents by adding classTabHide to the div */
  if (!div.className.match(this.REclassTabHide)) {
    div.className += ' ' + this.classTabHide;
  }
  this.navClearActive(tabberIndex);

  return this;
};


tabberObj.prototype.tabShow = function(tabberIndex)
{
  /* Show the tabberIndex tab and hide all the other tabs */

  var div;

  if (!this.tabs[tabberIndex]) { return false; }

  /* Hide all the tabs first */
  this.tabHideAll();

  /* Get the div that holds this tab */
  div = this.tabs[tabberIndex].div;

  /* Remove classTabHide from the div */
  div.className = div.className.replace(this.REclassTabHide, '');

  /* Mark this tab navigation link as "active" */
  this.navSetActive(tabberIndex);

  /* If the user specified an onTabDisplay function, call it now. */
  if (typeof this.onTabDisplay == 'function') {
    this.onTabDisplay({'tabber':this, 'index':tabberIndex});
  }

  return this;
};

tabberObj.prototype.navSetActive = function(tabberIndex)
{
  /* Note: this method does *not* enforce the rule
     that only one nav item can be active at a time.
  */

  /* Set classNavActive for the navigation list item */
  this.tabs[tabberIndex].li.className = this.classNavActive;

  return this;
};


tabberObj.prototype.navClearActive = function(tabberIndex)
{
  /* Note: this method does *not* enforce the rule
     that one nav should always be active.
  */

  /* Remove classNavActive from the navigation list item */
  this.tabs[tabberIndex].li.className = '';
  
  return this;
};


/*==================================================*/


function tabberAutomatic(tabberArgs)
{
  /* This function finds all DIV elements in the document where
     class=tabber.classMain, then converts them to use the tabber
     interface.

     tabberArgs = an object to send to "new tabber()"
  */
  var
    tempObj, /* Temporary tabber object */
    divs, /* Array of all divs on the page */
    i; /* Loop index */

  if (!tabberArgs) { tabberArgs = {}; }

  /* Create a tabber object so we can get the value of classMain */
  tempObj = new tabberObj(tabberArgs);

  /* Find all DIV elements in the document that have class=tabber */

  /* First get an array of all DIV elements and loop through them */
  divs = document.getElementsByTagName("div");
  for (i=0; i < divs.length; i++) {
    
    /* Is this DIV the correct class? */
    if (divs[i].className &&
	divs[i].className.match(tempObj.REclassMain)) {
      
      /* Now tabify the DIV */
      tabberArgs.div = divs[i];
      divs[i].tabber = new tabberObj(tabberArgs);
    }
  }
  
  return this;
}


/*==================================================*/


function tabberAutomaticOnLoad(tabberArgs)
{
  /* This function adds tabberAutomatic to the window.onload event,
     so it will run after the document has finished loading.
  */
  var oldOnLoad;

  if (!tabberArgs) { tabberArgs = {}; }

  /* Taken from: http://simon.incutio.com/archive/2004/05/26/addLoadEvent */

  oldOnLoad = window.onload;
  if (typeof window.onload != 'function') {
    window.onload = function() {
      tabberAutomatic(tabberArgs);
    };
  } else {
    window.onload = function() {
      oldOnLoad();
      tabberAutomatic(tabberArgs);
    };
  }
}


/*==================================================*/


/* Run tabberAutomaticOnload() unless the "manualStartup" option was specified */

if (typeof tabberOptions == 'undefined') {

    tabberAutomaticOnLoad();

} else {

  if (!tabberOptions['manualStartup']) {
    tabberAutomaticOnLoad(tabberOptions);
  }

}


</script>
<!--        <script type="text/javascript" src="assets/tabber.js"></script>-->
        <link rel="stylesheet" href="assets/example.css" TYPE="text/css" MEDIA="screen">
        <!--<link rel="stylesheet" href="assets/example-print.css" TYPE="text/css" MEDIA="print">-->

        <script type="text/javascript">
            document.write('<style type="text/css">.tabber{display:none;}<\/style>');
            
            var request2;
            function getCourses(groupId){
                if (window.XMLHttpRequest)
                {
                    request2=new XMLHttpRequest();
                }
                else if(window.ActiveXObject)
                {
                    request2 =new ActiveXObject("Microsoft.XMLHTTP");
                }
                
                request2.onreadystatechange = updateCourses;
                
                request2.open('GET','/LADManagment/QueuesBoundary?timeStamp='+new Date().getTime()+"&group="+groupId,true);

                request2.send(null);
            } 
            function updateCourses(){
                if(request2.readyState == 4){
                    
                    document.getElementById("coursesDiv").innerHTML="";
                    
                    var xmlDoc = request2.responseXML;
                    var messages = xmlDoc.getElementsByTagName("course");
                    for(var i=0 ; i<messages.length ; i++){
                        currentCourse = messages[i];
                        
                        var out2 = currentCourse.childNodes[0].childNodes[0].nodeValue;
                        
                        var hyperLink = document.createElement("a");
                        hyperLink.href="/LADManagment/LapPageInitiator?group="+currentCourse.childNodes[1].childNodes[0].nodeValue
                                                         +"&course="+out2;
                        
                        
                        var button = document.createElement("input");
                        button.className = "btn";
                        button.type="button";
                        button.value=out2;
                        
                        hyperLink.appendChild(button);
                        
                        document.getElementById("coursesDiv").appendChild(hyperLink);
                    }
                }
            }
            function startUpload(labId){
                 if (window.XMLHttpRequest)
                {
                    request2=new XMLHttpRequest();
                }
                else if(window.ActiveXObject)
                {
                    request2 =new ActiveXObject("Microsoft.XMLHTTP");
                }
                
                alert(labId);
                request2.open('GET','/LADManagment/StartUpload?timeStamp='+new Date().getTime()+"&labid="+labId,true);

                request2.send(null);
            }
           function closeLab(labId){
   
               if (window.XMLHttpRequest)
                {
                    request2=new XMLHttpRequest();
                }
                else if(window.ActiveXObject)
                {
                    request2 =new ActiveXObject("Microsoft.XMLHTTP");
                }
                
                alert(labId);
                request2.open('GET','/LADManagment/CloseLab?timeStamp='+new Date().getTime()+"&labid="+labId,true);

                request2.send(null);
                window.location.reload(); 
           }
           function notifyDelivery(stuId,insId,labId){
               if (window.XMLHttpRequest)
                {
                    request2=new XMLHttpRequest();
                }
                else if(window.ActiveXObject)
                {
                    request2 =new ActiveXObject("Microsoft.XMLHTTP");
                }
                
                request2.open('GET','/LADManagment/NotifyDelivery?timeStamp='+new Date().getTime()+"&queue=Delivery"+"&insid="+insId+"&stuId="+stuId+"&labId="+labId,true);
                request2.send(null); 
           }
           
           
           var request4;
           function shfitLab(runLabID,shiftLabId){
                if (window.XMLHttpRequest)
                {
                    request4=new XMLHttpRequest();
                }
                else if(window.ActiveXObject)
                {
                    request4 =new ActiveXObject("Microsoft.XMLHTTP");
                }
                alert(runLabID);
                alert(shiftLabId)
                request4.open('GET','/LADManagment/ShiftQueues?timeStamp='+new Date().getTime()+"&runLabID="+runLabID+"&shifitLabID="+shiftLabId,true);
                request4.send(null); 
           }
        </script>
        
        <script>
            var req;
            
          function getQueues(labId){
              if(window.XMLHttpRequest)
                req=new XMLHttpRequest();
            else if(window.ActiveXObject)
                req=new ActiveXObject("Microsoft.XMLHTTP");
            
            req.onreadystatechange=handleReq2;
            
            var url ="/LADManagment/QueuesBoundary?date="+new Date().getTime()+"&labKey="+labId;
            req.open("GET",url,true);
            req.setRequestHeader('Content-Type', 'text/xml');
            req.send();
          }
          function handleReq2(){
              if(req.readyState==4)
              {
                  var returnXml = req.responseXML;
                  var assistanceUl = document.getElementById("assistance");
                assistanceUl.innerHTML="";
                var deliveryUl = document.getElementById("delivery");
                  deliveryUl.innerHTML="";
                  
                  var studentsInAssist = returnXml.getElementsByTagName("st1");
                    for(var i=0 ; i<studentsInAssist.length ; i++){
                        currentStudent = studentsInAssist[i];
                        var currentStudentId = currentStudent.childNodes[0].childNodes[0].nodeValue;
                        var currentStudentName = currentStudent.childNodes[1].childNodes[0].nodeValue;
                        
                        var liElement = document.createElement("li");
                        liElement.innerHTML=currentStudentName;
                        var inputButton = document.createElement("input");
                         inputButton.type="button";
                         inputButton.addEventListener("click", function(){
                              
                              if (window.XMLHttpRequest)
                                {
                                    request2=new XMLHttpRequest();
                                }
                                else if(window.ActiveXObject)
                                {
                                    request2 =new ActiveXObject("Microsoft.XMLHTTP");
                                }       
                               
                                request2.open('GET','/LADManagment/NotifyAssistance?timeStamp='+new Date().getTime()+"&queue=Assistance"+"&insid="+${sessionScope.insID}+"&stuId="+currentStudentId,true);
                                request2.send(null); 
                            });
                         inputButton.value="notify";
                         
                         <c:if test="${sessionScope.labStatus == 'false'}">
                             inputButton.disabled = true;
                         </c:if>
                         
                        
                        liElement.appendChild(inputButton);
                        assistanceUl.appendChild(liElement);
                    }
                              
                     var studentsInDelivery = returnXml.getElementsByTagName("st2");
                    for(var i=0 ; i<studentsInDelivery.length ; i++){
                        currentStudent = studentsInDelivery[i];
                        var currentStudentId = currentStudent.childNodes[0].childNodes[0].nodeValue;
                        var currentStudentName = currentStudent.childNodes[1].childNodes[0].nodeValue;
                        
                        var liElement = document.createElement("li");
                        liElement.innerHTML=currentStudentName;
                        var inputButton = document.createElement("input");
                         inputButton.type="button";
                         inputButton.addEventListener("click", function(){
                              
                              if (window.XMLHttpRequest)
                                {
                                    request2=new XMLHttpRequest();
                                }
                                else if(window.ActiveXObject)
                                {
                                    request2 =new ActiveXObject("Microsoft.XMLHTTP");
                                }       

                                request2.open('GET','/LADManagment/NotifyDelivery?timeStamp='+new Date().getTime()+"&queue=Delivery"+"&insid="+${sessionScope.insID}+"&stuId="+currentStudentId+"&labId="+${param.lab},true);
                                request2.send(null); 
                            });
                         inputButton.value="notify";
                         
                         <c:if test="${sessionScope.labStatus == 'false'}">
                             inputButton.disabled = true;
                         </c:if>
                         
                        
                        liElement.appendChild(inputButton);
                        deliveryUl.appendChild(liElement);
                    }   
                           
                           
                         
                        
                } 
      }
        </script>
    </head>
    <body onload="setInterval('getQueues(${param.lab})',3000)">
        <header>
        </header>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <center> <h1><font color="white"> Lab Management System</font></h1></center>
            </div>
        </nav><br/><br/><br/>
        <div class="tabber">
             <c:forEach var="lab" items='${sessionScope.labs}'>
<!--                <div class="tabbertab" id="${lab.labId}">-->
               <a href="/LADManagment/LabsController?lab=${lab.labId}" <c:if test="${param.lab == lab.labId}"> style="color:#FF0000;"</c:if> >${lab.name}</a>
            </c:forEach>
               
               <div id="contents">
                        <br/>
                        <center>
                            <input type="button" onclick="startUpload(${param.lab})" value="start upload" <c:if test="${sessionScope.labStatus == 'false'}"> disabled</c:if>/>
                            <input type="button" onclick="shfitLab(${param.lab},2)" value="Shift Queues" <c:if test="${sessionScope.labStatus == 'false'}"> disabled</c:if>/>
                        <input type="button" onclick="closeLab(${param.lab})" value="deactivate lab" <c:if test="${sessionScope.labStatus == 'false'}"> disabled</c:if>/>
                        </center>
                        <br/>
                        <div class="group-btn">
                            <h1>Students List</h1>
                            <ul>
                                <c:forEach var="student" items='${sessionScope.students}'>
                                    <li>
                                       ${student.userName}
                                       <!--getAssignment(${param.lab},${student.studentId})-->
                                            <a href="/LADManagment/DownloadAssignment?timeStamp='+new Date().getTime()+&labid=${param.lab}&stuId=${student.studentId}">
                                                <input type="button" value="View Uploaded Assignment" <c:if test="${sessionScope.labStatus == 'true'}"> disabled </c:if>/></a>
                                    </li>
                                </c:forEach>
                            </ul>
                            </div>
                        <div class="group-btn">
                            <h1>Assistance Queue</h1>
                            <ul id="assistance">
                                <c:forEach var="studentt" items='${sessionScope.asStudents}'>
                                    <li>
                                       ${studentt.userName}
                                       <!--/LADManagment/NotificationBoundary?notifyAssist=${studentt.userName}&queue=Assistance-->
                                       <input type="button" onclick="notifyAssistance(${studentt.studentId},${sessionScope.insID})" value="notify"  <c:if test="${sessionScope.labStatus == 'false'}"> disabled</c:if> />
                                    </li>
                                </c:forEach>
                            </ul>
                            </div>
                        <div class="group-btn">
                            <h1>Delivery Queue</h1>
                            <ul id="delivery">
                                <c:forEach var="studenttt" items='${sessionScope.deStudents}'>
                                    <li>
                                       ${studenttt.userName}
                                       <!--<a href="/LADManagment//NotificationBoundary?notifyAssist=${studenttt.userName}&queue=delivery">-->
                                           <input type="button" onclick="notifyDelivery(${studenttt.studentId},${sessionScope.insID},${param.lab})" value="notify" <c:if test="${sessionScope.labStatus == 'false'}"> disabled</c:if> />
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
                
             
            </div>
       <!-- <a href="/LADManagment/LabsController?lab=1"<c:if test="${param.lab == '1'}"> style="color:#FF0000;"</c:if> >Lab 1</a>
        <a href="/LADManagment/LabsController?lab=2"<c:if test="${param.lab == '2'}"> style="color:#FF0000;"</c:if> >Lab 2</a>
        <a href="/LADManagment/LabsController?lab=3"<c:if test="${param.lab == '3'}"> style="color:#FF0000;"</c:if> >Lab 3</a>-->

        <footer>
        </footer>
    </body>
</html>

