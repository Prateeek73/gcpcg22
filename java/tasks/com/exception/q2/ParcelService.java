package com.exception.q2;

public class ParcelService {
    public void validateParcel(Parcel parcel) throws SamePlaceException, WeightException{
        if(parcel.source == parcel.destination){
            throw new SamePlaceException("Same Place Exception");
        }
        if(parcel.netWeightInKg > 50 || parcel.netWeightInKg > parcel.totalWeightInKg){
            throw new WeightException("Weight Exception");
        }
    }
    public double totalBill(Parcel parcel) throws SamePlaceException, WeightException{
		try{
			validate(parcel);
		} catch(SamePlaceException ex){
            //ex.printStackTrace();
            System.err.println(ex.getMessage());
			return -1;
        } catch(WeightException ex){
            //ex.printStackTrace();
            System.err.println(ex.getMessage());
			return -1;
        } catch(Exception ex){
			//ex.printStackTrace();
            System.err.println(ex.getMessage());
		}
        double bill = parcel.netWeightInKg * 10;
        return bill;
    }
}
