package DAO;

import java.util.List;

import Entity.Ospite;

public interface OspiteDaoInterface {
    void createOspite(Ospite ospite);
    Ospite getOspiteById(int id);
    void deleteOspite(int id);
    void updateOspite(Ospite ospite);
    List<Ospite> getAllOspiti();
}