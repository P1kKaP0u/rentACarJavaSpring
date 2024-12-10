package kodlama.io.rentACar.business.responses;

import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
public class GetAllBrandsResponse {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
