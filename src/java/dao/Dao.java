/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import dto.Dto;
import java.util.List;

/**
 *
 * @author Al-Jazayeerly
 */
public interface Dao {
    /**
     * 
     * @param dto
     * @return 
     */
    public List<Dto> get(Dto dto);
    /**
     * 
     * 
     * @param dto 
     */
    public void update(Dto dto);
    /**
     * 
     * @param dto 
     */
    public void delete(Dto dto);
    /**
     * 
     * @param dto 
     */
    public void add(Dto dto);
    
}
