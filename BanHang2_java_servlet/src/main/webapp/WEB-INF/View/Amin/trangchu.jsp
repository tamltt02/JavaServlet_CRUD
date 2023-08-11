<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Thống kê</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Thống kê</li>
                        </ol>
                        <div class="row">
                            <div class="col-xl-3 col-md-6">
                                <div class="card  mb-4">
                                    <div class="card-body bg-primary text-white fw-bold ">
                                     <div class="row">
                                       <div class="col-12 text-center"> Số sản phẩm trong kho 
                                           <br>
                                           <h1 class="text-center">${slSP }</h1>
                                       </div>
                                           </div>
                                    </div>
                               
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-warning text-white mb-4">
                                    <div class="card-body bg-warning text-white fw-bold ">
                                        <div class="row">
                                          <div class="col-12 text-center"> Đơn Hàng
                                              <br>
                                              <h1 class="text-center">${slDH }</h1>
                                          </div>
                                              </div>
                                       </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-success text-white mb-4">
                                    <div class="card-body bg-success text-white fw-bold ">
                                        <div class="row">
                                          <div class="col-12 text-center">Khách hàng
                                              <br>
                                              <h1 class="text-center">${slu }</h1>
                                          </div>
                                              </div>
                                       </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-danger text-white mb-4">
                                    <div class="card-body bg-danger text-white fw-bold ">
                                        <div class="row">
                                          <div class="col-12 text-center"> Bài viết
                                              <br>
                                              <h1 class="text-center">26</h1>
                                          </div>
                                              </div>
                                       </div>
                                </div>
                            </div>
                        </div>
                         <div class="row mt-5">
                             <div class="col-4">
                                <div class="card" style="width: 100%;">
                                    <div class="card-body">
                                   <div class="text-center">  <h4 >Bán chạy nhất Ngày</h4></div>
                                   <div class="row">
                                    <table class="table m">
                                        <thead>
                                          <tr>
                                            <th scope="col">Mã heo</th>
                                            <th scope="col">Tên heo</th>
                                            <th scope="col">Số lượng</th>
                                            <th scope="col">Doanh thu</th>
                                          </tr>
                                        </thead>
                                        <tbody>
                                          <tr>
                                            <th scope="row">${ngay.id }</th>
                                            <td>${ngay.name }</td>
                                            <td>${ngaysl } con</td>
                                            <td>$${dtNgay }</td>
                                          </tr>
                                        </tbody>
                                      </table>

                                   </div>
                                   
                                    </div>
                                  </div>
                                  
                             </div>
                             <div class="col-4">
                                <div class="card" style="width: 100%;">
                                    <div class="card-body">
                                   <div class="text-center">  <h4 >Bán chạy nhất Tháng</h4></div>
                                   <div class="row">
                                    <table class="table">
                                     
                                        <thead>
                                            <tr>
                                            <th scope="col">Mã heo</th>
                                            <th scope="col">Tên heo</th>
                                            <th scope="col">Số lượng</th>
                                            <th scope="col">Doanh thu</th>
                                          </tr>
                                        </thead>
                                        <tbody>
                                          <tr>
                                            <th scope="row">${thang.id }</th>
                                            <td>${thang.name }</td>
                                            <td>${thangsl } con</td>
                                            <td>$${dtThang }</td>
                                          </tr>
                                       
                                        </tbody>
                                      </table>

                                   </div>
                                   <hr>
                                    </div>
                             </div>
                             </div>
                             <div class="col-4">
                                <div class="card" style="width: 100%;">
                                    <div class="card-body">
                                   <div class="text-center ">  <h4 >Bán chạy nhất Năm</h4></div>
                                   <div class="row">
                                    <table class="table">
                                         <thead>
                                            <tr>
                                            <th scope="col">Mã heo</th>
                                            <th scope="col">Tên heo</th>
                                            <th scope="col">Số lượng</th>
                                            <th scope="col">Doanh thu</th>
                                          </tr>
                                        </thead>
                                        <tbody>
                                          <tr>
                                            <th scope="row">${nam.id }</th>
                                            <td>${nam.name }</td>
                                            <td>${namsl } con</td>
                                            <td>$${dtnam }</td>
                                          </tr>
                                       
                                        </tbody>
                                      </table>

                                   </div>
                                   <hr>
                                    </div>
                             </div>
                             </div>
                         </div>
                    </div>
                </main>
           