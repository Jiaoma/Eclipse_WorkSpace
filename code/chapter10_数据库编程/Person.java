import java.sql.*;
import java.io.*;
import java.util.*;
public class Person
{
    private String personName="";
    private String nickName="";
    private String email="";
    private String mobilePhone="";
    private int personId;

    public Person()
    {
    }
    public Person(int personId,String personName,String nickName,String email,String mobilePhone)
    {
		this.personId=personId;
		this.personName=personName;
		this.nickName=nickName;
		this.email=email;
        this.mobilePhone=mobilePhone;
	}
    public Person(String personName,String nickName,String email,String mobilePhone)
    {
        this.personName=personName;
        this.nickName=nickName;
        this.email=email;
        this.mobilePhone=mobilePhone;
    }

    public String getPersonName()
    {
        return personName;
    }
    public void setPersonName(String personName)
    {
        this.personName=personName;
    }
    public String getNickName()
	{
	    return nickName;
	 }
	 public void setNickName(String nickName)
	 {
	    this.nickName=nickName;
    }
    public String getEmail()
	{
	    return email;
	}
    public void setEmail(String email)
	{
	    this.email=email;
    }
    public String getMobilePhone()
	{
	    return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone)
	{
	    this.mobilePhone=mobilePhone;
    }
    public int getPersonId()
    {
		return personId;
	}
	public void setPersonId(int personId)
	{
		this.personId=personId;
	}

   	//为了便于使用DefaultTableModle而添加的
	public  Vector getVector()
	{
		Vector<Object> v=new Vector<Object>();
		v.add(personId);
		v.add(personName);
		v.add(nickName);
		v.add(email);
		v.add(mobilePhone);
		return v;
	}

	//为了便于使用DefaultTableModle而添加的
	public Person(Vector v)
	{
		personId=((Integer)v.get(0)).intValue();
		personName=(String)v.get(1);
		nickName=(String)v.get(2);
		email=(String)v.get(3);
        mobilePhone=(String)v.get(4);
	}
}