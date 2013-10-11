import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
* Created by pret on 10/11/13.
*/
@XmlAccessorType(XmlAccessType.FIELD)
class Product {

    @XmlValue
    protected String value;    //Название софтины в поле ПРОДУКТ
    @XmlAttribute
    protected Integer price;      //Атрибут PRICE в поле Продукт
    @XmlAttribute
    protected Integer size;       //Атрибут SIZE в поле Продукт

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Product{" + "value=" + value + ", price=" + price + ", size=" + size + '}';
    }
}
