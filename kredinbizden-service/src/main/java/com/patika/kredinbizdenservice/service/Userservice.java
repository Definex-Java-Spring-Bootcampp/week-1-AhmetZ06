import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public User getUserWithMostApplications() {
    User userWithMostApplications = null;
    int maxApplicationCount = 0;
    
    for (Application application : applications) {
        int applicationCount = application.getUser().getApplications().size();
        if (applicationCount > maxApplicationCount) {
            maxApplicationCount = applicationCount;
            userWithMostApplications = application.getUser();
        }
    }
    
    return userWithMostApplications;
}