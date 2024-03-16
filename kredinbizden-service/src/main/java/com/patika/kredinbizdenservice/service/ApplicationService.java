import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.Loan;
import com.patika.kredinbizdenservice.model.Product;
import com.patika.kredinbizdenservice.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ApplicationService {//burda classların içerisinde değil de yeni bir method oluşturarak ordan application oluşturursak, 
    //yani mesela creating an application, her create edildiğinde biz bunu bir listede saklarız, böylelikle de orda o
    //oluşan aplikasyonları bir listede saklayabiliriz

    private final List<Application> applications = new ArrayList<>();
    private Application highestLoanApplication = null;


    public Application createLoanApplication(Loan loan, User user, LocalDateTime applicationTime) {
        Application application = new Application(loan, user, applicationTime); 
        applications.add(application);
        updateHighestLoanApplication(application);
        return application;
    }

    public Application createProductApplication(Product product, User user, LocalDateTime applicationTime) {
        Application application = new Application(product, user, applicationTime); 
        applications.add(application);
        return application;
    }

    public List<Application> getAllApplications() {
        return applications;
    }



    public List<Application> getLastMonthApplications() {
        List<Application> lastMonthApplications = new ArrayList<>();
        LocalDateTime oneMonthAgo = LocalDateTime.now().minusMonths(1);

        for (Application application : applications) {
            if (application.getLocalDateTime().isAfter(oneMonthAgo)) {
                lastMonthApplications.add(application);
            }
        }
        return lastMonthApplications;

    }


    private void updateHighestLoanApplication(Application application) {
        if (application.getLoan() != null) {
            if (highestLoanApplication == null || application.getLoan().getAmount().compareTo(highestLoanApplication.getLoan().getAmount()) > 0) {
                highestLoanApplication = application;
            }
        }
    }

    public User getHighestLoanApplicant() {
        return highestLoanApplication != null ? highestLoanApplication.getUser() : null;
    }

    public BigDecimal getHighestLoanAmount() {
        return highestLoanApplication != null ? highestLoanApplication.getLoan().getAmount() : BigDecimal.ZERO;
    }
    

    public List<Application> getApplicationsByEmail(String email) {
        
        List<Application> userApplications = new ArrayList<>();

        for (Application application : applications) {
            User user = application.getUser();
            if (user.getEmail().equals(email)) {
                userApplications.add(application);
            }
        }

        return userApplications;
    }
}
