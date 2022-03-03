
enum IssueStatus{

OPEN,

CLOSED

}


Issue{

 status: IssueStatus
 
 priorityValue: int 


}


IssueService{

findIssueWithLowestPriority(): Optional < Issue >

Map < IssueStatus , List < Issue > > mapIssuesByStatus(Collection < Issue > issues)
 
findTotalPriorityValue(): Optional < Long >

findTotalPriorityValueByStatus(IssueStatus status) : Optional < Long >
 

}


Main Class {

verify IssueService operations are working properly

}


