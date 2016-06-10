/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.service;

import fr.utbm.formation.entity.Client;
import java.util.List;

/**
 *
 * @author Cyntia KEMAMEN
 */
public interface ClientService {
    public List<Client> getAllClient();
    public Client getClient(int clientId);
    public void addClient(Client c);
    public void deleteClient(int clientId);
    public void updateClient(int clientId, Client c);
}
