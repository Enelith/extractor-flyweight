package extractor_flyweight.model.data;

import java.util.List;

import extractor_flyweight.model.core.ExtractorModel;
import extractor_flyweight.model.data.core.interfaces.IComponent_Data;
import extractor_flyweight.model.structure.Component_Structure_2;
import extractor_flyweight.model.structure.core.Component_StructureFactory;

/**
 * @author jvinh
 */
public class Component_Data_2 extends ExtractorModel implements IComponent_Data {
    private String lastname;
    private String firstname;
    private String birthdate;
    private String gender;
    private String zipcode;
    private String countryCode;
    private String city;
    
    @Override
    public List<String> GetLine() {
	return ((Component_Structure_2) Component_StructureFactory.getComponent_Structure(Component_Structure_2.class))
		    .generateParticle(this, this.isFullDisplayMode());
    }
    
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
}
