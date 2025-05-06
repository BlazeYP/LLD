package librarymgmtsystem.models;

import java.util.ArrayList;

public class Library {
    private Integer id;
    private ArrayList<Rack> racks;

    public Library() {
    }

    public Library(Integer id, int rackCount) {
        this.id = id;
        ArrayList<Rack> racks = new ArrayList<>();
        for(int i=0 ; i<rackCount; i++) {
            Rack rack = new Rack(i);
            racks.add(rack);
        }
        this.racks = racks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Rack> getRacks() {
        return racks;
    }

    public void setRacks(ArrayList<Rack> racks) {
        this.racks = racks;
    }
}
