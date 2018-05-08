package hu.unideb.nursenotes.frontend.listview.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDataModel {

    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private LocalDate travelTime;
    private LocalDate timeSpent;
    private int age;
    private int wage;

}
