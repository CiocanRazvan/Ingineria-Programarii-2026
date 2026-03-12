import java.util.ArrayList;
import java.util.List;

public class Category {

    private Long categoryId;
    private String name;

    private Category parentCategory;
    private List<Category> subcategories;

    public Category(Long categoryId, String name, Category parentCategory) {
        this.categoryId = categoryId;
        this.name = name;
        this.parentCategory = parentCategory;
        this.subcategories = new ArrayList<>();
    }

    public List<Category> getSubcategories() {
        return subcategories;
    }

    public void addSubcategory(Category subcategory) {
        subcategories.add(subcategory);
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }
}
