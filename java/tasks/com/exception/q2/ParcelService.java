package com.exception.q2;

public class ParcelService {

    public void validateParcel(Parcel parcel) throws SamePlaceException, WeightException{
        if(parcel.source == parcel.destination){
            throw new SamePlaceException("Same Place Exception");
        }
        else if(parcel.netWeightInKg > 50 || parcel.netWeightInKg > parcel.totalWeightInKg){
            throw new WeightException("Weight Exception");
        }
    }

    public double totalBill(Parcel parcel) throws SamePlaceException, WeightException{
        validateParcel(parcel);
        double bill = parcel.netWeightInKg * 10;
        return bill;
    }
}
