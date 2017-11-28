    import java.io.*; //����java.io�������е���
����public class FileFilterTest{
��������public static void main(String args[]){
����������File dir=new File("d://ex"); //��File �����ʾһ��Ŀ¼
����������Filter filter=new Filter("java"); //����һ����Ϊjava�Ĺ�����
����������System.out.println("list java files in directory "+dir);
����������String files[]=dir.list(filter); //�г�Ŀ¼dir�£��ļ���׺��
�������������������������������������������� Ϊjava�������ļ�
����������for(int i=0;i<files.length;i++){
������������File f=new File(dir,files[i]); //ΪĿ¼dir �µ��ļ���Ŀ¼
�������������������������������������������� ����һ��File ����
��������������if(f.isFile()) //����ö���Ϊ��׺Ϊjava���ļ���
������������������������������ ���ӡ�ļ���
����������������System.out.println("file "+f);
��������������else
����������������System.out.println("sub directory "+f ); //�����Ŀ¼
�������������������������������������������������������� ���ӡĿ¼��
����������}
��������}
������}
������class Filter implements FilenameFilter{
��������String extent;
��������Filter(String extent){
����������this.extent=extent;
��������}
��������public boolean accept(File dir,String name){
����������return name.endsWith("."+extent); //�����ļ��ĺ�׺��
��������}
������}
