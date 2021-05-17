package com.Shop.test.Service;

<<<<<<< HEAD
import com.Shop.test.Dto.AddtoCartDto;
=======

>>>>>>> 19cc2252e0256480ccbea32aca8784da066c9ae8
import com.Shop.test.Dto.CartDto;
import com.Shop.test.Dto.CartItemDto;
import com.Shop.test.Model.CartModel;
import com.Shop.test.Model.ProductsModel;
import com.Shop.test.Model.UserModel;
import com.Shop.test.repostitory.CartRepository;
import com.Shop.test.repostitory.ProductsRepository;
import com.Shop.test.repostitory.UserRepository;
import com.Shop.test.util.SecurityUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
import javax.transaction.Transactional;
>>>>>>> 19cc2252e0256480ccbea32aca8784da066c9ae8
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Data
@AllArgsConstructor
@Service
@Transactional
public class CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductsRepository productsRepository;



<<<<<<< HEAD
    public CartModel addnewproducttocart(ProductsModel productsModel , Long productId, Integer quantity){

        //TODO:add list product to cart
=======


    public CartModel addnewproducttocart( ProductsModel productsModel,Integer quantity,Long productId){
>>>>>>> 19cc2252e0256480ccbea32aca8784da066c9ae8

        Optional<Long> opt = SecurityUtil.getcurrentUserId();

        if(opt.isEmpty()){
            throw new IllegalStateException("no user id");
        }
        Long aLong = opt.get();

        Optional<UserModel> userid = userRepository.findById(aLong);
        if(userid.isEmpty()){
            throw new IllegalStateException("user id not found");

        }
        UserModel userModel = userid.get();

        Long productId1 = productId;
<<<<<<< HEAD
        Optional<ProductsModel> byId = productsRepository.findById(productId1);
        ProductsModel productsModel1 = byId.get();
=======
        Optional<ProductsModel> productid = productsRepository.findById(productId1);

        ProductsModel productsModel1 = productid.get();


>>>>>>> 19cc2252e0256480ccbea32aca8784da066c9ae8

        CartModel cartModel = new CartModel();
        cartModel.setId(userModel.getId());
        cartModel.setProductId(productsModel1.getProductId());
        cartModel.setProductsModel(productsModel1);
        cartModel.setQuantity(quantity);
<<<<<<< HEAD

=======
>>>>>>> 19cc2252e0256480ccbea32aca8784da066c9ae8

        Double total=productsModel1.getProductprice()*cartModel.getQuantity();
        cartModel.setTotalprice(total);


        return cartRepository.save(cartModel);


    }

    public void findcart(){
        Optional<Long> opt = SecurityUtil.getcurrentUserId();
        if(opt.isEmpty()){
            throw new IllegalStateException("no user id");
        }

        Long aLong = opt.get();
        Optional<UserModel> userid = userRepository.findById(aLong);
        if(userid.isEmpty()) {
            throw new IllegalStateException("no user id");
        }
        UserModel userModel = userid.get();




    }

    public CartDto listCartItem(Long id){
        Optional<Long> aLong = SecurityUtil.getcurrentUserId();
        Long aLong1 = aLong.get();
        Optional<UserModel> userid = userRepository.findById(aLong1);
        if(userid.isEmpty()){
            throw new IllegalStateException("user id not found");

        }
        UserModel userModel = userid.get();

        List<CartModel> cartModelById = cartRepository.findCartModelById(userModel.getId());
        List<CartItemDto>cartItem= new ArrayList<>();
        for(CartModel cartModel:cartModelById){
            CartItemDto cartItemDto=getDtofromCart(cartModel);
            cartItem.add(cartItemDto);
        }

        double totocost=0;

        for(CartItemDto cartItemDto:cartItem){
            totocost+=(cartItemDto.getProductsModel().getProductprice()*cartItemDto.getQuantity());

<<<<<<< HEAD
        return cartModel;
    }

   /* public List<CartModel> addtocart(CartModel cartModel) {
        Optional<Long> opt = SecurityUtil.getcurrentUserId();
        if(opt.isEmpty()){
            throw new IllegalStateException("opt null");
        }

        Long userid = opt.get();
        Optional<UserModel> uid = userRepository.findById(userid);
        UserModel userModel = uid.get();

        List<CartModel> allById = cartRepository.findAllById(userModel.getId());
        Double totalcost=0.0;
        for(CartModel cartModel1:allById){

        }

        return allById;

    }*/
    public CartDto listCartItem(Long id){
        Optional<Long> opt = SecurityUtil.getcurrentUserId();
        if(opt.isEmpty()){
            throw new IllegalStateException("opt is null");
        }

        Long aLong = opt.get();

        Optional<UserModel> userid = userRepository.findById(aLong);
        UserModel userModel = userid.get();

        //  cartlist =จำนวนProduct ทั้งหมดที่มีการเลือก
        // cartItem = สร้างarrayList เปล่าๆมาเพื่อรับค่าจาก cartlist
        //(CartModel cartmodel :cartlist) คือการเอาค่าจาก cartlist ไปใส่ในตัวแปร cartItem
        //CartItemDto cartItemDto= getDtoFromCart(cartModel) คือการเอาcartModel ไปใส่ใน cartItemDto สำหรับ ArrayList
        List<CartModel> cartList = cartRepository.findAllById(userModel.getId());
        List<CartItemDto>cartItem=new ArrayList<>();
        for(CartModel cartModel:cartList){
         CartItemDto cartItemDto= getDtoFromCart(cartModel);
            cartItem.add(cartItemDto);
        }


        double totalcost=0;

        //CartItemDto cartItemDto:cartItem รับค่า cartitem ไปใส่ใน cartItemDto แล้วคำนวณราคาสินค้า
        for(CartItemDto cartItemDto:cartItem){
            totalcost+=(cartItemDto.getProductsModel().getProductprice()*cartItemDto.getQuantity());

        }
        CartDto cartDto = new CartDto(cartItem,totalcost);
        return cartDto;


    }

    //ใช้สำหรับรับข้อมูลจาก cartmodel
   public static CartItemDto getDtoFromCart(CartModel cartModel){
      CartItemDto cartItemDtot = new CartItemDto(cartModel);
      return cartItemDtot;
   }

=======
        }
        CartDto cartDto=new CartDto(cartItem,totocost);
        return cartDto;

    }


    public static CartItemDto getDtofromCart(CartModel cartModel){
        CartItemDto cartItemDto=new CartItemDto(cartModel);
        return cartItemDto;
    }

>>>>>>> 19cc2252e0256480ccbea32aca8784da066c9ae8




}
