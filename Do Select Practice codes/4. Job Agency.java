import java.util.*;

class CompanyJobRepository {
	static String getJobPrediction(int age, String highestQualification) throws NotEligibleException{
		String jobPrediction = "";
		if(age <= 18){
			throw new NotEligibleException("You are underage for any job");
		} else if(highestQualification.equals("B.E") && age>=21){
			jobPrediction = "We have openings for junior developer";
		} else if( (highestQualification.equals("M.S") || highestQualification.equals("PhD")) && age>=26){
			jobPrediction = "We have openings for senior developer";
		} else{
			throw new NotEligibleException("Sorry we have no openings for now");
		}
		return jobPrediction;
	}
}

public class Source {
	String searchForJob(int age, String highestQualification){
		String result = "";
		try{
			if(age >= 200 || age <=0){
				throw new NotEligibleException("The age entered is not typical for a human being");
			}
			result = CompanyJobRepository.getJobPrediction(age, highestQualification);
		} catch(NotEligibleException ex){
			//ex.printStackTrace();
			return ex.getMessage();
		}
		return result; 
	}
	public static void main(String args[] )  {
		// Scanner sc = new Scanner(System.in);
		int age = 21;
		String highestQualification = "B.E";
		Source obj = new Source();
		String result = obj.searchForJob(age, highestQualification);
		System.out.println(result);
		// sc.close();
	}
}
class NotEligibleException extends Exception {
	public NotEligibleException(String msg){
		super(msg);
	}
}