package com.example.firstAPI.resources;

import com.example.firstAPI.DTO.SellerDTO;
import com.example.firstAPI.models.Department;
import com.example.firstAPI.models.Seller;
import com.example.firstAPI.services.SellerService;
import com.example.firstAPI.services.exceptions.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sellers")
public class SellerResource {

    private final SellerService sellerService;

    public SellerResource(SellerService sellerService){
        this.sellerService = sellerService;
    }

    @GetMapping
    public List<Seller> findAll(){
   return sellerService.findAll();

    }

    @GetMapping(value = "/{id}")
    public Seller findById(@PathVariable  long id){
        return sellerService.findById(id);

    }


@PostMapping(value = "/insert")
    public Seller insertSeller (@RequestBody Seller seller){

        SellerDTO sellerDTO = new SellerDTO();
        sellerDTO.setName(seller.getName());
        sellerDTO.setEmail(seller.getEmail());
        sellerDTO.setBaseSalary(seller.getBaseSalary());
        sellerDTO.setBirthDate(seller.getBirthDate());

        Department department = new Department();
        department.setId(seller.getDepartment().getId());
        sellerDTO.setDepartment(department);

       return sellerService.insert(sellerDTO);


}

@PutMapping(value = "/put/{id}")
    public SellerDTO putSeller(@RequestBody SellerDTO obj , @PathVariable long id){

            SellerDTO sellerDTO = new SellerDTO();
            sellerDTO.setName(obj.getName());
            sellerDTO.setEmail(obj.getEmail());
            sellerDTO.setBaseSalary(obj.getBaseSalary());
            sellerDTO.setBirthDate(obj.getBirthDate());
            sellerDTO.setDepartment(obj.getDepartment());
            return   sellerService.putSeller(sellerDTO,id);
            
}






}
