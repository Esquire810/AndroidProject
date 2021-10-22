package com.jixl.e_ticket.flight;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jixl.e_ticket.auth.User;

import java.util.UUID;

public class Add {

    public void writeFlight() {

        Flight flight1 = new Flight("PS", 52022, "Ukraine International Airlines", "Kyiv", "20/06/2021", "05:10", "Paris", "20/06/2021", "13:00", "plane");
        Flight flight2 = new Flight("PS", 54078, "Ukraine International Airlines", "Kyiv", "20/06/2021", "23:45", "Bangladesh", "21/06/2021", "04:30", "plane");

        String flightId = UUID.randomUUID().toString();

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference mRef = mDatabase.child("flight/" + flightId);
        mRef.setValue(flight2);
    }
}
