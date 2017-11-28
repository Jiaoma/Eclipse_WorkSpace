    import java.io.*; //引入java.io包中所有的类
　　public class FileFilterTest{
　　　　public static void main(String args[]){
　　　　　File dir=new File("d://ex"); //用File 对象表示一个目录
　　　　　Filter filter=new Filter("java"); //生成一个名为java的过滤器
　　　　　System.out.println("list java files in directory "+dir);
　　　　　String files[]=dir.list(filter); //列出目录dir下，文件后缀名
　　　　　　　　　　　　　　　　　　　　　　 为java的所有文件
　　　　　for(int i=0;i<files.length;i++){
　　　　　　File f=new File(dir,files[i]); //为目录dir 下的文件或目录
　　　　　　　　　　　　　　　　　　　　　　 创建一个File 对象
　　　　　　　if(f.isFile()) //如果该对象为后缀为java的文件，
　　　　　　　　　　　　　　　 则打印文件名
　　　　　　　　System.out.println("file "+f);
　　　　　　　else
　　　　　　　　System.out.println("sub directory "+f ); //如果是目录
　　　　　　　　　　　　　　　　　　　　　　　　　　　　 则打印目录名
　　　　　}
　　　　}
　　　}
　　　class Filter implements FilenameFilter{
　　　　String extent;
　　　　Filter(String extent){
　　　　　this.extent=extent;
　　　　}
　　　　public boolean accept(File dir,String name){
　　　　　return name.endsWith("."+extent); //返回文件的后缀名
　　　　}
　　　}
