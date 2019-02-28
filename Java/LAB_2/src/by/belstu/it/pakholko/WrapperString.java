package by.belstu.it.pakholko;

import java.util.Objects;

public class WrapperString {
    private String str;

    @Override
    public String toString() {
        return "WrapperString{" +
                "str='" + str + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrapperString that = (WrapperString) o;
        return Objects.equals(str, that.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str);
    }

    public WrapperString(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }


    public void replace (char old, char neww)
    {
        str = str.replace(old, neww);
        System.out.println("method: " + str);
    }

    public void anonim(){
        WrapperString w = new WrapperString(str){
            public void replace (char old, char neww){
                str = str.replace(old, neww);
                System.out.println("method_anonim: " + str);
            }
            public void delete (char newchar)
            {
                System.out.println(newchar);
            }
        };
    }

}

/**
 *  @author Alyona
 *  @version 1.0.
 */
