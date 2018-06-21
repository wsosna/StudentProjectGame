package backend.locations;

import backend.offices.*;
import backend.wallet.Wallet;

import java.util.ArrayList;
import java.util.List;


public class City {
    private String name;
    private List<Office> officeList;


    public City(String name) {
        this.name = name;
        this.officeList = new ArrayList<>();
    }

    public void buyOffice(Office office) {
        if(Wallet.getInstance().getBankBalance() >= office.getPrice()) {
            getOfficeList().add(office);
            Wallet.getInstance().subtractMoneyFromBankBalance(office.getPrice());
        }
    }

    public int getCityGain() {
        int cityGain = 0;
        for (int i = 0; i < officeList.size(); i++) {
            cityGain += officeList.get(i).getGain();
        }
        return cityGain;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Office>getOfficeList() {
        return officeList;
    }
}
