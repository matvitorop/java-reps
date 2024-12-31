package com.education.ztu;

public class StringBuilderExample {
    public static void main(String[] args)
    {
        int num1 = 4;
        int num2 = 36;

        //Додавання підрядків
        StringBuffer sb1 = new StringBuffer();
        sb1.append(num1).append(" + ").append(num2).append(" = ").append(num1+num2);
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer();
        sb2.append(num1).append(" - ").append(num2).append(" = ").append(num1 - num2);
        System.out.println(sb2);

        StringBuffer sb3 = new StringBuffer();
        sb3.append(num1).append(" * ").append(num2).append(" = ").append(num1 * num2);
        System.out.println(sb3);

        //Заміна командами deleteCharAt, insert
        StringBuffer modifiedString = new StringBuffer(sb1);
        int charToDelete = modifiedString.indexOf("=");
        modifiedString.deleteCharAt(charToDelete);
        modifiedString.insert(charToDelete, "equals");
        System.out.println(modifiedString);

        //Заміна командами replace
        StringBuffer sb2Modified = new StringBuffer(sb2);
        int equalIndex = sb2Modified.indexOf("=");
        sb2Modified.replace(equalIndex,equalIndex+1,"equals");
        System.out.println(sb2Modified);

        //Обернутий рядок
        StringBuffer sb3Modified = new StringBuffer(sb3);
        sb3Modified.reverse();
        System.out.println(sb3Modified);

        //Довжина рядка та довжина буфера
        System.out.println(sb3Modified.length());

        //sb3Modified.trimToSize(); //-зменшення буфера до його фактичного розміру
        System.out.println(sb3Modified.capacity());
    }

}
