import java.io.*;

public class ListContracts {
    public Contract[] contract;

    public ListContracts(Contract[] contract) {
        this.contract = contract;
    }

    public Contract[] getContract() {
        return contract;
    }

    public void setContract(Contract[] contract) {
        this.contract = contract;
    }

    public static int getCountOfContracts(String path) {
       int count = 0;
        try {
            File file = new File(path);
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

    public static Contract[] getListContractsObject(int count, String path){
        Contract[] contracts = new Contract[count];
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fr);
            String line = bufferedReader.readLine();
            //contracts[0] = (Contract) line;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return contracts;
    }
}
