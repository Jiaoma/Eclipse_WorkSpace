import java.io.*;
/**
   Title:Engineer��<br>
   Description:ͨ��Engineer��˵��java�е��ĵ�ע��<br>
   @author John
   @version 1.00
 */

 public class Engineer
 {
   /**
    ������ʦ������
    */
    private String engineer_name;

   /** ���ǹ��췽��
     @param name ����engineer������
     */
    public Engineer(String name)
    {
       engineer_name=name;
    }

   /** ����repairing������˵��
    @param sum ������Ҫ����Ļ�������
    @param alltime ������Ҫ�������ʱ��
    @return �ɹ�����Ļ���������
    */
    public int repairing(int sum,int alltime)
    {
		return 1;
    }
 }


 //javadoc -d doc Engineer.java
 //javadoc -d doc -version -author Engineer.java ���汾�����߳�ȡ����
 //javadoc -d doc2 *.java ��ȡ��ǰĿ¼��������İ���
 //��ȡ������Ϣ
 //����������ͽӿڡ����еĺ��ܱ����ķ��������еĺ��ܱ����ĳ�Ա����