package TestBean;

import java.util.Calendar;

public class PersonInformation implements java.io.Serializable {

    public PersonInformation(){

    }

    public String getDate(){
        return Calendar.getInstance().getTime().toString();
    }
}
