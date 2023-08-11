package com.example.assignment.service.impl;

import com.example.assignment.dto.ChiTietSanPhamDTO;
import com.example.assignment.dto.ChiTietSanPhamDTOForm;
import com.example.assignment.entity.ChiTietSanPham;
import com.example.assignment.mapper.ChiTietSanPhamMapper;
import com.example.assignment.reponsitory.ChiTietSanPhamRepository;
import com.example.assignment.service.ChiTietSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChiTietSPServiceImpl implements ChiTietSPService {
    @Autowired
    ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Autowired
    ServletContext app ;
    @Autowired
    private ChiTietSanPhamMapper mapper;

    @Override
    public Page<ChiTietSanPhamDTO> getSanPham(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo,size);
        Page<ChiTietSanPham> data = chiTietSanPhamRepository.findAll(pageable);
        return   data.map(t -> mapper.convertToDTO(t));
    }

    @Override
    public List<ChiTietSanPhamDTO> getAll() {
        List<ChiTietSanPham> list = chiTietSanPhamRepository.findAll();
        List<ChiTietSanPhamDTO> listDTO = new ArrayList<>();
        for (ChiTietSanPham chiTietSanPham : list){
            listDTO.add(mapper.convertToDTO(chiTietSanPham));
        }
        return listDTO;
    }

    @Override
    public List<ChiTietSanPhamDTO> getCTSPnew() {

        List<ChiTietSanPham> list = chiTietSanPhamRepository.getCTSPnew();
        List<ChiTietSanPhamDTO> listDTO = new ArrayList<>();
        for (ChiTietSanPham chiTietSanPham : list){
            listDTO.add(mapper.convertToDTO(chiTietSanPham));
        }
        return listDTO;
    }

    @Override
    public List<ChiTietSanPhamDTO> getCTSPchay() {
        List<ChiTietSanPham> list = chiTietSanPhamRepository.getCTSPchay();
        List<ChiTietSanPhamDTO> listDTO = new ArrayList<>();
        for (ChiTietSanPham chiTietSanPham : list){
            listDTO.add(mapper.convertToDTO(chiTietSanPham));
        }
        return listDTO;
    }

    @Override
    public ChiTietSanPhamDTO add(ChiTietSanPhamDTOForm chiTietSanPhamDTOForm) {
        ChiTietSanPham chiTietSanPham = mapper.convertToEntityForm(chiTietSanPhamDTOForm);
        chiTietSanPham.setId(null);
        //add anh
        String uploaRootPath = app.getRealPath("img");
        File uploadRootDir = new File(uploaRootPath);
        if(!uploadRootDir.exists()){
            uploadRootDir.mkdirs();
        }
        try {
            String filename = chiTietSanPhamDTOForm.getMoTa().getOriginalFilename();
            File severFile = new File(uploadRootDir.getAbsoluteFile() + File.separator
                    + filename);
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(severFile));
            stream.write(chiTietSanPhamDTOForm.getMoTa().getBytes());
            stream.close();
            chiTietSanPham.setMoTa(filename);
        }catch (Exception e){

        }

        chiTietSanPham = chiTietSanPhamRepository.save(chiTietSanPham);
        return mapper.convertToDTO(chiTietSanPham);
    }

//    @Override
//    public ChiTietSanPhamDTO updateform(ChiTietSanPhamDTOForm chiTietSanPhamDTOForm) {
//        ChiTietSanPham chiTietSanPham = mapper.convertToEntityForm(chiTietSanPhamDTOForm);
//            chiTietSanPham.setMoTa(this.chiTietSanPhamRepository.findById(chiTietSanPham.getId()).get().getMoTa());
//        if(this.chiTietSanPhamRepository.findById(chiTietSanPham.getId()) != null) {
//            chiTietSanPham = chiTietSanPhamRepository.save(chiTietSanPham);
//            return mapper.convertToDTO(chiTietSanPham);
//        }
//        return null;
//    }
    @Override
    public ChiTietSanPhamDTO update(ChiTietSanPhamDTO chiTietSanPhamDTO) {
        ChiTietSanPham chiTietSanPham = mapper.convertToEntity(chiTietSanPhamDTO);


            chiTietSanPham.setMoTa(this.chiTietSanPhamRepository.findById(chiTietSanPham.getId()).get().getMoTa());

        if(this.chiTietSanPhamRepository.findById(chiTietSanPham.getId()) != null) {
            chiTietSanPham = chiTietSanPhamRepository.save(chiTietSanPham);
//            request.getSession().setAttribute("message", "Cập nhật thành công");
            return mapper.convertToDTO(chiTietSanPham);
        }
        return null;
    }

    @Override
    public ChiTietSanPhamDTO delete(Integer id) {
        Optional<ChiTietSanPham> chiTietSanPham = this.chiTietSanPhamRepository.findById(id);
        if(chiTietSanPham.isPresent())
            this.chiTietSanPhamRepository.deleteById(id);
        return mapper.convertToDTO(chiTietSanPham.get());
    }

    @Override
    public ChiTietSanPhamDTO findById(Integer id) {
        Optional<ChiTietSanPham> c = this.chiTietSanPhamRepository.findById(id);
        if(c.isPresent()) {
            ChiTietSanPhamDTO dto = mapper.convertToDTO(c.get());
            return dto;
        }
        return null;
    }

    @Override
    public Page<ChiTietSanPhamDTO> getSPbydongSP(String dongSP, Integer page) {
      Pageable pageable = PageRequest.of(page,2);
        Page<ChiTietSanPham> list = chiTietSanPhamRepository.findProductByCategory(dongSP, pageable);
        return   list.map(t -> mapper.convertToDTO(t));
    }


}
