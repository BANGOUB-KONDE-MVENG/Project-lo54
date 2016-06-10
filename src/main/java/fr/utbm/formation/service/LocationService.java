/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.service;

import fr.utbm.formation.entity.Location;
import java.util.List;

/**
 *
 * @author Cyntia KEMAMEN
 */
public interface LocationService {
    public List<Location> getAllLocation();
    public void addLocation(Location l);
    public void deleteLocation(Location l);
    public void updateLocation(int cityId, String city);
    
}
