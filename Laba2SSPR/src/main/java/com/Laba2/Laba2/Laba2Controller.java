package com.Laba2.Laba2;

import com.Laba2.Laba2.core.Car;
import com.Laba2.Laba2.core.Category;
import com.Laba2.Laba2.core.Nadstroika;
import com.Laba2.Laba2.core.TypeTechnika;
import com.Laba2.Laba2.svc.CategoryService;
import com.Laba2.Laba2.svc.Laba2Service;
import com.Laba2.Laba2.svc.TypeTechnikaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class Laba2Controller {

    private Laba2Service laba2Service;
    private CategoryService categoryService;
    private String sortDateMethod = "ASC";
    private TypeTechnikaService typeTechnikaService;

    @Value("${upload.path}")
    private String uploadPath;


    @Autowired
    public void setLaba2Service(Laba2Service laba2Service){
        this.laba2Service = laba2Service;
    }


    public void setCategoryService(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    public void setSortDateMethod(String sortDateMethod) {
        this.sortDateMethod = sortDateMethod;
    }

    public void setTypeTechnikaService(TypeTechnikaService typeTechnikaService) {
        this.typeTechnikaService = typeTechnikaService;
    }

    public Laba2Service getLaba2Service() {
        return laba2Service;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public String getSortDateMethod() {
        return sortDateMethod;
    }

    public TypeTechnikaService getTypeTechnikaService() {
        return typeTechnikaService;
    }

    @GetMapping
    public String list(Model model){
        return "index";
    }

    @GetMapping("/spectechnika")
    public String listSpecTexhiks(Model model){
        List<TypeTechnika> typeBook = laba2Service.findAllByOrderByImgPathAsc();
        model.addAttribute("types", typeBook);
        model.addAttribute("sort", sortDateMethod);
        return "spectechnika";
    }

    @GetMapping("/builderTexhiks/{id}")
    public String listTexhiks(@PathVariable Integer id, Model model){
        TypeTechnika technika = laba2Service.technika(id);
        List<Category> categoryBook = laba2Service.findByTechnika(technika);
        List<Car> carBook = laba2Service.findByTypeTechnika(technika);
        model.addAttribute("cars", carBook);
        model.addAttribute("categorys", categoryBook);
        model.addAttribute("sort", sortDateMethod);
        model.addAttribute("technika",technika);
        return "builderTexhiks";
    }

    @GetMapping("/sort/{sortDate}")
    public String sortChoose(@PathVariable String sortDate) {
        sortDateMethod = sortDate;
        return "redirect:/";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Car car = laba2Service.getCarById(id);
        model.addAttribute("car", car);
        List<Nadstroika> nadstroika = laba2Service.findAllByOrderByIdAsc();
        TypeTechnika technika = laba2Service.technika(car.getTypeTechnika().getId());
        List<Category> categoryBook = laba2Service.findByTechnika(technika);
        model.addAttribute("nadstroikas", nadstroika);
        model.addAttribute("categorys", categoryBook);
        model.addAttribute("typeTech", technika);
        return "operations/edit";
    }

    @GetMapping("/editTypeTechnika/{id}")
    public String editTypeTechnika(@PathVariable Integer id, Model model){
        TypeTechnika technika = laba2Service.getTypeTechnikaById(id);
        model.addAttribute("technika", technika);
        return "operations/editTypeTechnika";
    }

    @GetMapping("/editCategory/{id}")
    public String editCategory(@PathVariable Integer id, Model model){
        Category category = laba2Service.getCategoryById(id);
        model.addAttribute("category", category);
        TypeTechnika technika = laba2Service.technika(category.getTechnika().getId());
        model.addAttribute("typeTech", technika);
        return "operations/editCategory";
    }

    @GetMapping("/admin/{id}")
    public String newCar(@PathVariable Integer id, Model model) {
        List<Nadstroika> nadstroika = laba2Service.findAllByOrderByIdAsc();
        TypeTechnika technika = laba2Service.technika(id);
        List<Category> categoryBook = laba2Service.findByTechnika(technika);
        model.addAttribute("nadstroikas", nadstroika);
        model.addAttribute("categorys", categoryBook);
        model.addAttribute("typeTech", technika);
        return "admin";
    }

    @GetMapping("/postTypeTechnika")
    public String newTypeTechnika(){
        return "postTypeTechnika";
    }

    @GetMapping("/postCategory/{id}")
    public String newCategory(@PathVariable Integer id, Model model){
        TypeTechnika technika = laba2Service.technika(id);
        model.addAttribute("typeTech",technika);
        return "postCategory";
    }

    @PostMapping("/update")
    public String saveNote(@RequestParam Integer id, @RequestParam String name,
                           @RequestParam ("imgPath") MultipartFile imgPath, @RequestParam String date,
                           @RequestParam String baza, @RequestParam Nadstroika nadstroika,
                           @RequestParam Category category,  @RequestParam TypeTechnika typeTechnika) {

        laba2Service.updateCar(id, "/images/" + imgPath.getOriginalFilename() ,name, date, baza, nadstroika, category, typeTechnika);
        return "redirect:/";
    }

    @PostMapping("/updateCategory")
    public String saveCategory(@RequestParam Integer id, @RequestParam String name,
                               @RequestParam ("imgPath") MultipartFile imgPath, @RequestParam TypeTechnika typeTechnika) {

        laba2Service.updateCategory(id, name, imgPath.getOriginalFilename(),typeTechnika);
        return "redirect:/";
    }

    @PostMapping("/updateTypeTechnika")
    public String saveTypeTechnika(@RequestParam Integer id, @RequestParam String name,
                                   @RequestParam ("imgPath") MultipartFile imgPath) {

        laba2Service.updateType(id, "/images/" + imgPath.getOriginalFilename(), name);
        return "redirect:/";
    }

    @PostMapping("/save")
    public String updateNote(@RequestParam String name, @RequestParam ("imgPath") MultipartFile imgPath, @RequestParam String date,
                             @RequestParam String baza, @RequestParam Nadstroika nadstroika,
                             @RequestParam Category category, @RequestParam TypeTechnika typeTechnika) throws IOException {

        laba2Service.saveCar(new Car(name,"/images/" + imgPath.getOriginalFilename(),date,baza, nadstroika, category, typeTechnika));
        return "redirect:/";
    }

    @PostMapping("/saveTypeTechnika")
    public String updateType(@RequestParam String name,@RequestParam ("imgPath") MultipartFile imgPath) throws IOException {
        laba2Service.saveType(new TypeTechnika(name,"/images/" + imgPath.getOriginalFilename()));
        return "redirect:/";
    }


    @PostMapping("/saveCategory")
    public String updateCategory(@RequestParam String name,@RequestParam ("imgPath") MultipartFile imgPath, @RequestParam TypeTechnika typeTechnika) throws IOException {
        laba2Service.saveCategory(new Category(name,"/images/" + imgPath.getOriginalFilename(), typeTechnika));
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        laba2Service.deleteCar(id);
        return "redirect:/";
    }

    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable Integer id){
        laba2Service.deleteCategory(id);
        return "redirect:/";
    }

    @GetMapping("/deleteTypeTech/{id}")
    public String deleteTypeTech(@PathVariable Integer id, Model model){
        try {
            laba2Service.deleteType(id);
        }catch(DataIntegrityViolationException e){

            List<TypeTechnika> typeBook = laba2Service.findAllByOrderByImgPathAsc();
            model.addAttribute("types", typeBook);
            model.addAttribute("sort", sortDateMethod);
            model.addAttribute("message", "Нельзя так делать!!!");
            return "spectechnika";
        }
        return "redirect:/";
    }

    private List<Car> filterAndSort() {
        List<Car> carBook = null;
        switch (sortDateMethod) {
            case "ASC":
                carBook = laba2Service.findAllByOrderByNameAsc();
                break;
        }
        return carBook;
    }

}
