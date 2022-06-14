import java.io.*;
import java.util.Arrays;

public class Contract {

    private String nameOfContract;

public Contract[] contracts;

    public String getNameOfContract() {
        return nameOfContract;
    }


    public void setNameOfContract(String nameOfContract) {
        this.nameOfContract = nameOfContract;
    }


    public Contract(String nameOfContract) {
        //try {
//            String regex1 = "docnum";
//            String regex2 = "contract";
//            if (nameOfContract.length() != 15) {
//                throw new ErrorNameOfContractException("Длина номера документа должна состоять из 15 символов");
//            }
//            if (!(nameOfContract.substring(0, 6).equals(regex1)) || (nameOfContract.substring(0, 8).equals(regex2))) {
//                throw new ErrorNameOfContractException("Документ должен начинаться с docnum или contract");
//            } else
        this.nameOfContract = nameOfContract;

        //} catch (ErrorNameOfContractException e) {
        //  System.out.println(e);
        // }
    }

    public int countOfStringInFile(String path) {
        File file = new File(path);
        int count = 0;
        try {
            FileReader fr = new FileReader(file);
            int symbol;
            do {
                symbol = fr.read();
                if (symbol == '\n') count++;
            } while (fr.ready());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public static String[] fillingArrayOfString(int countOfString, String path) {
        String[] str = new String[countOfString];
        try {
            File myfile = new File("ContractNumbers.txt");
            FileReader myfr = new FileReader(myfile);
            //считываем файл при помощи FileReader
            BufferedReader mybr = new BufferedReader(myfr);
            String line = mybr.readLine();//вначале заносим первую строку
            str[0] = line;
            int count = 0;
            while (line != null) {
                str[count] = line;
                count++;
                System.out.println(line);
                //считываем остальные строки
                line = mybr.readLine();
            }
            System.out.println(Arrays.toString(str));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        return str;
    }

    public static void myValidator(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            try {
                String regex1 = "Docnum";
                String regex2 = "Contract";
                if (strings[i].length() != 15) {
                    System.out.println(strings[i] + " - Длина номера документа должна состоять из 15 символов");
                    throw new ErrorNameOfContractException(" Длина номера документа должна состоять из 15 символов");
                } else if (!(strings[i].startsWith("Docnum") || (strings[i].startsWith("Contract")))) {
                    System.out.println(strings[i] + " - Документ должен начинаться с Docnum или Contract");
                    throw new ErrorNameOfContractException(" Документ должен начинаться с docnum или contract");
                } else {
                    System.out.println(strings[i] + " - Документ валиден");
                }
            } catch (ErrorNameOfContractException e) {
                System.out.println(e);
            }
        }

    }

    public static void writeInFile(String[] strings) {
        //предварительно очищаем файлы от предыдущего содержимого
        try (FileWriter writer = new FileWriter("NoValidNumbers.txt", false);
             FileWriter writer2 = new FileWriter("ValidNumbers.txt", false)) {
            writer.write("");
            writer2.write("");
            // writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        for (String s : strings) {
            if (s.length() != 15) {
                try (FileWriter writer = new FileWriter("NoValidNumbers.txt", true)) {
                    writer.write(s + "Длина номера документа должна состоять из 15 символов");
                    writer.append('\n');
                   // writer.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (!(s.startsWith("Docnum") || (s.startsWith("Contract")))) {
                try (FileWriter writer = new FileWriter("NoValidNumbers.txt", true)) {
                    writer.write(s + "Документ должен начинаться с Docnum");
                    writer.append('\n');
                    //writer.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

             else  {
                //System.out.println(s.startsWith("Docnum"));
                try (FileWriter writer = new FileWriter("ValidNumbers.txt", true)) {
                    writer.write(s);
                    writer.append('\n');
                   // writer.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

}
