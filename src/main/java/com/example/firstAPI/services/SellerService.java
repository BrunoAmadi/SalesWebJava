package com.example.firstAPI.services;
import com.example.firstAPI.DTO.SellerDTO;
import com.example.firstAPI.models.Department;
import com.example.firstAPI.models.Seller;
import com.example.firstAPI.repositories.SellerRepository;
import com.example.firstAPI.services.exceptions.DbIntegrityException;
import com.example.firstAPI.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SellerService {


    private final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {

        this.sellerRepository = sellerRepository;
    }


    public List<SellerDTO> findAll() {
        List<Seller> listSeller = sellerRepository.findAll();
        List<SellerDTO> listSellerDTO = listSeller.stream().map(this::transferDTO).toList();
        return listSellerDTO;
    }


    public SellerDTO findById(long id) throws ResourceNotFoundException {

        Optional<Seller> optinalSeller = sellerRepository.findById(id);

        if (optinalSeller.isPresent()) {

            return transferDTO(optinalSeller.get());

        } else {
            throw new ResourceNotFoundException("Id não encontrado " + id);

        }

    }


    public SellerDTO insert(SellerDTO sellerDTO) {

        Seller seller = new Seller();
        seller.setName(sellerDTO.getName());
        seller.setEmail(sellerDTO.getEmail());
        seller.setBaseSalary(sellerDTO.getBaseSalary());
        seller.setBirthDate(sellerDTO.getBirthDate());

        Department department = new Department();
        department.setId(sellerDTO.getDepartment().getId());
        seller.setDepartment(department);

        return transferDTO(sellerRepository.save(seller));

    }


    public SellerDTO putSeller(SellerDTO sellerDTO, long id)  throws ResourceNotFoundException {


        if (sellerRepository.findById(id).isPresent()) {
           Seller seller = sellerRepository.findById(id).get();
            seller.setName(sellerDTO.getName());
            seller.setEmail(sellerDTO.getEmail());
            seller.setBirthDate(sellerDTO.getBirthDate());
            seller.setBaseSalary(sellerDTO.getBaseSalary());
            seller.setDepartment(sellerDTO.getDepartment());
            return transferDTO(sellerRepository.save(seller));

        } else {
            throw new ResourceNotFoundException("Usuario não encontrado");
        }


    }


    public void deleteSeller(long id) throws DbIntegrityException {
try{

    if(sellerRepository.existsById(id)) {
        sellerRepository.deleteById(id);
    }

} catch(RuntimeException e){
    throw new DbIntegrityException("Não é possivel deletar um vendedor que possui muitas vendas alocadas");
}


    }

    public SellerDTO transferDTO(Seller obj) {
        SellerDTO sellerDTO = new SellerDTO();
        sellerDTO.setName(obj.getName());
        sellerDTO.setEmail(obj.getEmail());
        sellerDTO.setBirthDate(obj.getBirthDate());
        sellerDTO.setBaseSalary(obj.getBaseSalary());
        sellerDTO.setDepartment(obj.getDepartment());
        return sellerDTO;


    }


}




