import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
* Created by pret on 10/11/13.
*/
@XmlRootElement(name = "Soft")
class Soft {

    @XmlElement(name = "Company", required = true)
    private List<Company> company = new ArrayList<Company>();    //Получаем список компаний

    public List<Company> getCompany() {
        return this.company;
    }

    @Override
    public String toString() {
        return "Soft{" + "company=" + company + '}';
    }
}
