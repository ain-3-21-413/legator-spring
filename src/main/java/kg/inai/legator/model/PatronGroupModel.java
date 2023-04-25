package kg.inai.legator.model;

public record PatronGroupModel(
    String name,
    int checkedOutDuration,    
    int holdDuration,    
    int renewedDuration,    
    int checkedOutCount,
    int holdCount,
    int renewsAllowedCount
) {

}
