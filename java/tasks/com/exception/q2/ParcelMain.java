package com.exception.q2;

public class ParcelMain {
    public static void main(String[] args) {
        Parcel parcel = new Parcel( "Delhi", "Mumbai", 20, 21);
        ParcelService service = new ParcelService();
        double bill = service.totalBill(parcel);
        System.out.println(bill);
    }
}
