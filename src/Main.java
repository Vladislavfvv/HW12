import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Contract contract = new Contract("docnum789012345");
        //System.out.println(contract.getNameOfContract());
        //System.out.println("Введите путь к файлу c его названием и расширением:");
        //Scanner scanner = new Scanner(System.in);
        //String path = scanner.next();
        //System.out.println(path);
//        String[] strings = null; //массив строк
//        int count = 0;//количество строк в файле
//        char symbol;
//        FileReader fr = null;
//        try{ //(FileReader fr = new FileReader("ContractNumbers.txt")) {
//            //пытаемся открыть файл
//            fr = new FileReader("ContractNumbers.docx");
//            do{//цикл чтения симв из файла и подсчет их кол-ва
//              symbol = (char)fr.read();
//              //если есть символ переноса строки - считаем количество строк - увеличение на 1
//                if (symbol == '\n') {
//                    System.out.println((int)symbol + " ");
//                    count++;
//                    System.out.println(count + " ");}
//            }while (fr.ready());//пока файл читается
//            //int i = -1;
//            // while ((i = fr.read()) != -1){
//            //    System.out.println((char) i);
//           // }
//        } catch (IOException e) {
//            System.out.println("IO error" + e);;
//        }
//        finally {
//            //закрыть поток
//            try{
//                if (fr != null) fr.close();
//            }catch (IOException e){
//                System.out.println("File close error");
//            }
//        }
//        System.out.println(count);

        int countOfString = contract.countOfStringInFile("ContractNumbers.txt");
        System.out.println("Количество строк(контрактов) в документе: " + countOfString);
        System.out.println("//////////////////");
        String[] strings = new String[countOfString];
        strings = contract.fillingArrayOfString(countOfString, "ContractNumbers.txt");
        System.out.println("//////////////////");
        System.out.println(Arrays.toString(strings));

        System.out.println("//////////////////");
        Contract.myValidator(strings);

        Contract.writeInFile(strings);


        System.out.println("\\\\\\\\\\\\\\ListContracts");
        int count123 = ListContracts.getCountOfContracts("ContractNumbers.txt");
        int n = 5;
        System.out.println("Array1");
        int[][] arr1 = ArrayWriter.createArray(n);
        ArrayWriter.soutArr(arr1);
        System.out.println("Array2");
        int[][] arr2 = ArrayWriter.createArray(n);
        ArrayWriter.soutArr(arr2);
        System.out.println("Array3");
        int[][] arr3 = ArrayWriter.sumOfArray(arr1, arr2);
        ArrayWriter.soutArr(arr3);


        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                stringBuilder.append(arr1[i][j]);
                if (j != arr1.length - 1) {
                    stringBuilder.append(" ");
                } else
                {
                    stringBuilder.append(" + ");
                    for (int k = 0; k < arr2[i].length; k++) {
                        stringBuilder.append(arr2[i][k]);
                        if (k != arr2[i].length - 1) {
                            stringBuilder.append(" ");
                        } else {
                            stringBuilder.append(" = ");
                            for (int l = 0; l < arr3[i].length; l++) {
                                stringBuilder.append(arr3[i][l]);
                                if(l != arr3[i][l] - 1){
                                    stringBuilder.append(" ");
                                }
                                else stringBuilder.append("\n");
                            }stringBuilder.append("\n");
                        }
                    }
                }
            }
        }
        byte[] bytes = stringBuilder.toString().getBytes();

        try (FileOutputStream fileOutputStream = new FileOutputStream("Array.txt")){
            fileOutputStream.write(bytes);
            System.out.println("File has been written");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //ArrayWriter[][] arr2 = new ArrayWriter[n][n];
        //ArrayWriter arr2 = new ArrayWriter(2);
        // ArrayWriter array1 = arr1.createArray(2);
        // in
        //arr1.soutArr(arr1);
        //arr2.soutArr(arr2);


    }
}
