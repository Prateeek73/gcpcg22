package com.exception;

public class ParcelMain {
    public static void main(String[] args) {
        Parcel parcel = new Parcel("Delhi","Mumbai",20,21);
        ParcelService service = new ParcelService();
        double bill;
        try{
            bill = service.totalBill(parcel);
        }catch(SamePlaceException ex){
            System.out.println(ex.getMessage());
            bill = -1;
        }
        catch(WeightException ex){
            System.out.println(ex.getMessage());
            bill = -1;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            bill = -1;
        }
        System.out.println(bill);
    }
}
