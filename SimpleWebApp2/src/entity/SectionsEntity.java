package entity;

//import jakarta.persistence.*;
import javax.persistence.*;

@Entity
@Table(name = "sections", schema = "users", catalog = "")
public class SectionsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Section_Id")
    private Long sectionId;
    @Basic
    @Column(name = "Section")
    private String section;

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public SectionsEntity(String name){
        this.section=name;
    }
    public SectionsEntity(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SectionsEntity that = (SectionsEntity) o;

        if (sectionId != that.sectionId) return false;
        if (section != null ? !section.equals(that.section) : that.section != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Long result = sectionId;
        result = 31 * result + (section != null ? section.hashCode() : 0);
        return Math.toIntExact(result);
    }
}
