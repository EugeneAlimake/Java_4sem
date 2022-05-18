package Letters;

import java.util.Date;

public class Letter {
    private String Sender;
    private  String Recipient;
    private  String Subject_of_the_letter;
    public  String Text;
    public Date date;

    public String getSender()
    {
    return Sender;
    }
    public void SetName(String sender)
    {
    this.Sender=sender;
    }

    public String getRecipient()
    {
        return Recipient;
    }
    public void SetRecipient(String sender)
    {
        this.Recipient=Recipient;
    }

    public String getSubject_of_the_letter()
    {
        return Subject_of_the_letter;
    }
    public void SetSubject_of_the_letter(String subject_of_the_letter)
    {
        this.Subject_of_the_letter=subject_of_the_letter;
    }

    public String getText()
    {
        return Subject_of_the_letter;
    }
    public void SetText(String text)
    {
        this.Text=text;
    }

    public Date getDate()
    {
        return date;
    }
    public void SetDate(Date dates)
    {
        this.date=dates;
    }

    public Letter(String sender, String recipient, String subject_of_the_letter, String text, Date dates) {
        this.Sender = sender;
        this.Recipient = recipient;
        this.Subject_of_the_letter = subject_of_the_letter;
        this.Text=text;
        this.date=dates;
    }

    //endregion

    public String toString() {
        return "Письмо [Отправитель: \"" + Sender + "\"; Получатель: " + Recipient + "; Тема: " + Subject_of_the_letter + "Текст:"+Text+"Дата"+date+"]";
    }
}
