package Letters;

import java.util.Date;

public class people {
    private String Name;
    private String Surname;
    private String Middle_name;
    private Date Birthday;
    private String QTYSent;
    private  String QTYGet;

    public String getName()
    {
        return Name;
    }
    public void SetName(String name)
    {
        this.Name=name;
    }

    public String getSurname()
    {
        return Surname;
    }
    public void SetSurname(String surname)
    {
        this.Surname=surname;
    }

    public String getMiddle_name()
    {
        return Surname;
    }
    public void SetMiddle_name(String middle_name)
    {
        this.Middle_name=middle_name;
    }

    public Date getBirthday()
    {
        return Birthday;
    }
    public void SetBirthday(Date Dates)
    {
        this.Birthday=Dates;
    }

    public String getQTYGet()
    {
        return QTYGet;
    }
    public void SetQTYGet(String qTYGet)
    {
        this.QTYGet=qTYGet;
    }
    public String getQTYSent()
    {
        return QTYSent;
    }
    public void SetQTYSent(String qTYSent)
    {
        this.QTYSent=qTYSent;
    }
    public people(String name, String surname, String middle_name, Date birthday) {
        this.Name = name;
        this.Surname = surname;
        this.Middle_name = middle_name;
        this.Birthday=birthday;
      this.QTYGet="не требуется от запроса";
        this.QTYSent="не требуется от запроса";
    }
    public people(String name, String surname, String middle_name) {
        this.Name = name;
        this.Surname = surname;
        this.Middle_name = middle_name;
    }
    public people(String name, String surname, String middle_name, Date birthday, String qty, String qty1) {
        this.Name = name;
        this.Surname = surname;
        this.Middle_name = middle_name;
        this.Birthday=birthday;
        this.QTYSent=qty1;
        this.QTYGet=qty;
    }

    public String toString() {
        return "Человек [Имя: \"" + Name + "\"; Фамилия: " + Surname + "; Отчество: " + Middle_name + "День Рождение: "+Birthday+"; отправлено: "+QTYSent+"; принято: "+QTYGet+"]";
    }

}
