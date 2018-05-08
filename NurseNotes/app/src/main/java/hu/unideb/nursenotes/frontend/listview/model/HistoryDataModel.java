package hu.unideb.nursenotes.frontend.listview.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDataModel {

    private String firstName;
    private String lastName;
    private LocalDate date;

}
