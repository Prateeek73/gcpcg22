
enum IssueStatus{

OPEN,

CLOSED

}


Issue{

 status: IssueStatus
 
 priorityValue: int 


}


IssueService{

issues: List< Issues >

findIssueWithLowestPriority( ): Optional < Issue >

Map < IssueStatus , List < Issue > > mapIssuesByStatus()
 
findTotalPriorityValue( ): Optional < Long >

findTotalPriorityValueByStatus( IssueStatus status) : Optional < Long >
 

}


Main Class {

verify IssueService operations are working properly

}


