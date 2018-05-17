package hu.unideb.nursenotes.pojo.activity;

import java.util.List;

import hu.unideb.nursenotes.commons.pojo.response.ActivityResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ActivityReturnPojo {

    private int httpCode;
    private List<ActivityResponse> activityResponses;

}
