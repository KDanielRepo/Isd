import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class First {

    public void start(){
        String a = "bazy relacyjne, bazy tekstowe, bazy inne";
        String b = "bazy danych przykłady zastosowania";
        String c = "bazy danych - zalety; bazy danych - wady";
        String d = "składowanie danych";
        a = a.replaceAll("[,;-]","");
        b = b.replaceAll("[,;-]","");
        c = c.replaceAll("[,;-]","");
        d = d.replaceAll("[,;-]","");
        List<String> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        a +=" "+b+" "+c+" "+d;

        List<String> bag = Arrays.asList(a.split("[\\s ;,\\-]"));

        List<String> distinct = new ArrayList<>();
        bag.forEach(string->{
            if(!distinct.contains(string) && !string.isEmpty()){
                distinct.add(string);
            }
        });
        System.out.println("baza słow to:");
        distinct.forEach(System.out::println);
        int[][] has = new int[list.size()][distinct.size()];
        for (int i = 0; i < list.size(); i++) {//kazdy string
            List<String> split = Arrays.asList(list.get(i).split("[\\s]"));
            List<String> split2 = new ArrayList<>();
            for (int j = 0; j < split.size(); j++) {
                if(!split.get(j).isEmpty()){
                    split2.add(split.get(j));
                }
            }
            for (int j = 0; j < distinct.size(); j++) {
                for (int k = 0; k < split2.size(); k++) {
                    if(split2.get(k).equals(distinct.get(j))){
                        has[i][j] = 1;
                    }
                }
            }
        }
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            for (int j = 0; j < distinct.size(); j++) {
                System.out.print(has[i][j]);
            }
            System.out.println("");
        }
    }
    public void start2(){
        String a = "bazy relacyjne, bazy tekstowe, bazy inne";
        String b = "bazy danych przykłady zastosowania";
        String c = "bazy danych - zalety; bazy danych - wady";
        String d = "składowanie danych";
        a = a.replaceAll("[,;-]","");
        b = b.replaceAll("[,;-]","");
        c = c.replaceAll("[,;-]","");
        d = d.replaceAll("[,;-]","");
        List<String> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        a +=" "+b+" "+c+" "+d;

        List<String> bag = Arrays.asList(a.split("[\\s ;,\\-]"));

        List<String> distinct = new ArrayList<>();
        bag.forEach(string->{
            if(!distinct.contains(string) && !string.isEmpty()){
                distinct.add(string);
            }
        });
        System.out.println("baza słow to:");
        distinct.forEach(System.out::println);
        float[][] has = new float[list.size()][distinct.size()];
        for (int i = 0; i < list.size(); i++) {//kazdy string
            List<String> split = Arrays.asList(list.get(i).split("[\\s]"));
            List<String> split2 = new ArrayList<>();
            for (int j = 0; j < split.size(); j++) {
                if(!split.get(j).isEmpty()){
                    split2.add(split.get(j));
                }
            }
            for (int j = 0; j < distinct.size(); j++) {
                for (int k = 0; k < split2.size(); k++) {
                    if(split2.get(k).equals(distinct.get(j))){
                        has[i][j]++;
                    }
                }
            }
        }
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            for (int j = 0; j < distinct.size(); j++) {
                System.out.print(has[i][j]*normalize(has[i]));
                System.out.print(",");
            }
            System.out.println("");
        }
    }
    public void start3(){
        String a = "bazy relacyjne, bazy tekstowe, bazy inne";
        String b = "bazy danych przykłady zastosowania";
        String c = "bazy danych - zalety; bazy danych - wady";
        String d = "składowanie danych";
        a = a.replaceAll("[,;-]","");
        b = b.replaceAll("[,;-]","");
        c = c.replaceAll("[,;-]","");
        d = d.replaceAll("[,;-]","");
        List<String> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        a +=" "+b+" "+c+" "+d;

        List<String> bag = Arrays.asList(a.split("[\\s ;,\\-]"));

        List<String> distinct = new ArrayList<>();
        bag.forEach(string->{
            if(!distinct.contains(string) && !string.isEmpty()){
                distinct.add(string);
            }
        });
        System.out.println("baza słow to:");
        distinct.forEach(System.out::println);
        float[][] has = new float[list.size()][distinct.size()];
        float[][] has2 = new float[list.size()][distinct.size()];
        for (int i = 0; i < list.size(); i++) {//kazdy string
            List<String> split = Arrays.asList(list.get(i).split("[\\s]"));
            List<String> split2 = new ArrayList<>();
            for (int j = 0; j < split.size(); j++) {
                if(!split.get(j).isEmpty()){
                    split2.add(split.get(j));
                }
            }
            for (int j = 0; j < distinct.size(); j++) {
                for (int k = 0; k < split2.size(); k++) {
                    if(split2.get(k).equals(distinct.get(j))){
                        has[i][j]++;
                    }
                }
            }
            for (int j = 0; j < distinct.size(); j++) {
                for (int k = 0; k < split2.size(); k++) {
                    if(split2.get(k).equals(distinct.get(j))){
                        has2[i][j] = 1;
                    }
                }
            }
        }
        System.out.println();
        float[] sums = new float[distinct.size()];
        for (int i = 0; i < distinct.size(); i++) {
            float sum = 0f;
            for (int j = 0; j < list.size(); j++) {
                sum+=has2[j][i];
            }
            sums[i]=sum;
        }
        System.out.println("przed normalizacja: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            for (int j = 0; j < distinct.size(); j++) {
                System.out.print(has[i][j]*log2(4/sums[j]));
                has[i][j] = has[i][j]*log2(4/sums[j]).floatValue();
                System.out.print(",");
            }
            System.out.println("");
        }
        System.out.println();
        System.out.println("Po normalizacji: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            for (int j = 0; j < distinct.size(); j++) {
                System.out.print(has[i][j]*normalize(has[i]));
                System.out.print(",");
            }
            System.out.println("");
        }
    }
    public Float normalize(float[] a){
        float sum = 0f;
        for (int i = 0; i < a.length; i++) {
            sum+=Math.pow(a[i],2);
        }
        return new Double((1/Math.sqrt(sum))).floatValue();
    }
    public Double log2(float a){
        if (a == 0f) {
            return 0d;
        }
        Double b = (Math.log(a) / Math.log(2));
        return b;
    }
    //Log2(N/n) N - ilosc dokumentow zaindeksowanych (u nas 4), n - liczba dokumentow zawierajacych dane slowo (np: bazy jest w 3)
    public static void main(String[] args) {
        First first = new First();
        /*first.start();
        System.out.println("---------- TF TDM: -----------------------");
        first.start2();*/
        System.out.println("---------- TF TDM IDF: -----------------------");
        first.start3();
    }
    //zaliczenie 10 grudnia dla mojej grupy
    //ola 13 listopada

    //Preprocesing:
    //bag of words - dokument jest rozbijany na poszczególne słowa, w zależności ilu "gramowy" jest worek to po tyle słów zawartych jest w jednym stringu
    //usuwamy stop-words, czyli: i, od, blisko, moje
    //wyszukiwanie rdzenia słow, np: kotek, koteczek, kotuś. rdzen to kot i zastepuje te wszystkie slowa
    //
}
