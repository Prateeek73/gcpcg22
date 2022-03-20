import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


enum IssueStatus{
	OPEN,
	CLOSED;
}
class Issue{
	IssueStatus status;
	int priorityValue;
	Issue(IssueStatus status, int priorityValue){
		this.status = status;
		this.priorityValue = priorityValue;
	}
	IssueStatus getStatus(){
		return status;
	}
	int getPriorityValue(){
		return priorityValue;
	}
}
class IssueService{
	List<Issue> issues = new ArrayList<>();
	Optional<Issue> findIssueWithLowestPriority(){
		int minPriorityValue = Integer.MAX_VALUE;
		Issue found = null;
		for(Issue issue : this.issues){
			if(issue.getPriorityValue() < minPriorityValue){
				minPriorityValue = issue.getPriorityValue();
				found = issue;
			}
		}
		Optional<Issue> optional;
		if(found == null){
			optional = Optional.empty();
			return optional;
		}
		optional = Optional.of(found);
		return optional;
	}
	Map<IssueStatus, List<Issue>> mapIssuesByStatus(Collection<Issue> issues){
		Map<IssueStatus, List<Issue>> map = new HashMap<>();
		for(Issue issue : issues){
			IssueStatus status = issue.getStatus();
			if(map.containsKey(status)){
				List<Issue> list = map.get(status);
				list.add(issue);
			}
			else{	
				List<Issue> list = new ArrayList<>();
				list.add(issue);
				map.put(status, list);
			}
		}
		return map;
	}
	Optional<Long> findTotalPriorityValue(){
		long sum = 0;
		for(Issue issue : this.issues){
			sum += issue.getPriorityValue();
		}
		Optional<Long> optional;
		if(sum == 0){
			optional = Optional.empty();
			return optional;
		}
		optional = Optional.of(sum);
		return optional;
	}
	Optional<Long> findTotalPriorityValueByStatus(IssueStatus status){
		long sum = 0;
		for(Issue issue : this.issues){
			if(issue.getStatus() == status){
				sum += issue.getPriorityValue();
			}
		}
		Optional<Long> optional;
		if(sum == 0){
			optional = Optional.empty();
			return optional;
		}
		optional = Optional.of(sum);
		return optional;
	}
}
class MainClass{
	public static void main(String[] args){
		Collection<Issue> issues = new ArrayList<>();
		issues.add(new Issue(IssueStatus.OPEN, 2));
		issues.add(new Issue(IssueStatus.OPEN, 4));
		issues.add(new Issue(IssueStatus.CLOSED, 8));
		issues.add(new Issue(IssueStatus.OPEN, 12));
		issues.add(new Issue(IssueStatus.CLOSED, 14));
		issues.add(new Issue(IssueStatus.CLOSED, 9));
		IssueService service = new IssueService();
		service.issues.addAll(issues);
		System.out.println(service.findIssueWithLowestPriority());
		System.out.println(service.mapIssuesByStatus(issues));
		System.out.println(service.findTotalPriorityValue());
		System.out.println(service.findTotalPriorityValueByStatus(IssueStatus.OPEN));

	}
}