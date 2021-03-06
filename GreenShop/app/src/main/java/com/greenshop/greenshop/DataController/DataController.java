package com.greenshop.greenshop.DataController;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.greenshop.greenshop.Models.Cart;
import com.greenshop.greenshop.Models.Category;
import com.greenshop.greenshop.Models.Product;

import java.util.ArrayList;
import java.util.List;

public class DataController {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    public void getAllProducts(final MyCallBack myCallBack) {
        final ArrayList<Product> products = new ArrayList<>();
        final DatabaseReference myRef = database.getReference().child("Public-products");

        //final Semaphore semaphore = new Semaphore(0);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Log.d("TAG", dataSnapshot.child("CATE_1").getKey());
                for (DataSnapshot dsp: dataSnapshot.getChildren()) {
                    String userKey = dsp.getKey();
                    Log.d("TAG", userKey);
                    dsp.child(userKey).getValue(String.class);

                    for (DataSnapshot childDsp: dsp.child("products").getChildren()) {
                        String idProduct = childDsp.getKey();
                        Log.d("TAG2", idProduct);
                        String name = childDsp.child("name").getValue(String.class);
                        String desc = childDsp.child("description").getValue(String.class);
                        String descBenefit = childDsp.child("descriptionBenefit").getValue(String.class);
                        Integer sale = childDsp.child("sale").getValue(int.class);
                        Integer price = childDsp.child("price").getValue(int.class);
                        String[] image = new String[6];
                        int i = 0;
                        for (DataSnapshot dspImg: childDsp.child("images").getChildren()) {
                            image[i++] = dspImg.getValue(String.class);
                        }
                        Log.d("TAG3", name + desc + descBenefit + sale + price + image[0]);
                        products.add(new Product(idProduct, name, desc, descBenefit, userKey, sale, price, image));
                        Log.d("testSIZE", products.size()+"");
                    }
                }
                //semaphore.release();
                myCallBack.onCallback(products);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("testFireBase", "Failed to read value.", databaseError.toException());
            }
        });
        /*products.add(new Product("1", "Cây lưỡi hổ", "Loại cây này được mệnh danh là loại cây dành cho phòng ngủ, nó giúp sản sinh ra khí O2 thanh sạch cho gia đình vào ban đêm, khả năng này hầu như các loài cây khác không có được (ban đêm, thực vật cây cối thực hiện quá trình hô hấp, hấp thu O2 và thải ra CO2).", "Loại cây này được mệnh danh là loại cây dành cho phòng ngủ, nó giúp sản sinh ra khí O2 thanh sạch cho gia đình vào ban đêm, khả năng này hầu như các loài cây khác không có được (ban đêm, thực vật cây cối thực hiện quá trình hô hấp, hấp thu O2 và thải ra CO2). Cây không cần quá nhiều ánh sáng và nước nên phù hợp đặt ở nhiều góc trong nhà. Thêm vào đó kiểu lá đơn, cứng của loại cây này còn tượng trưng cho sự mạnh mẽ, sẽ rất ấn tượng khi dùng trong trang trí.", "1", 100000, 110000, new String[] {"cay_canh"}));
        products.add(new Product("2", "Cây tuyết tùng", "Cây tuyết tùng hay còn gọi là cây bách Nhật Bản thường được trồng làm cây bonsai cỡ nhỏ trang trí trong nhà. Tại Nhật Bản, cây tuyết tùng là loài cây được người ta coi là vô cùng thiêng liêng. Người ta tin rằng các linh hồn của người chết và của các vị thần đều sống ở bên trong cây.", "Cây tuyết tùng hay còn gọi là cây bách Nhật Bản thường được trồng làm cây bonsai cỡ nhỏ trang trí trong nhà. Tại Nhật Bản, cây tuyết tùng là loài cây được người ta coi là vô cùng thiêng liêng. Người ta tin rằng các linh hồn của người chết và của các vị thần đều sống ở bên trong cây.Về công dụng, loài cây này giúp không khí trong nhà tươi mát, cung cấp độ ẩm, loại bỏ bụi bẩn. Thậm chí, chúng còn giúp bạn giảm bớt triệu chứng đau đầu và đau nửa đầu. Tuyết tùng đòi hỏi trồng ở nơi có bóng mát và được tưới nước thường xuyên.", "1", 120000, 110000, new String[] {"cay_canh"}));
        products.add(new Product("3", "Cây sống đời", "Cây sống đời hay còn gọi là cây lá bỏng có nguồn gốc từ Madagascar. Khác hẳn với bề ngoài giản đơn của nó, cây sống đời có rất nhiều lợi ích bất ngờ.", "Nó tích nước trong phần thân lá và có tác dụng điều hòa không khí trong nhà bạn, thích hợp trồng tại nơi có không khí khô thoáng. Tuy nhiên, bạn cần chú ý không tưới cây quá nhiều nước và đặt ở nơi đón nhiều ánh sáng nhé.", "1", 90000, 110000, new String[] {"caycanh"}));
        products.add(new Product("4", "Cây Lan Ý", "Cây Lan Ý tại Việt Nam còn được gọi là cây bạch môn, huệ hòa bình hoặc vĩ hoa trắng.", "Cây Lan Ý tại Việt Nam còn được gọi là cây bạch môn, huệ hòa bình hoặc vĩ hoa trắng. Loài cây này còn có ý nghĩa tượng trưng cho “niềm hạnh phúc của phụ nữ”, tức là nếu bạn trồng loại cây này thì hạnh phúc và tình yêu sẽ tràn ngập khắp căn nhà đấy. Hơn thế nữa cây Lan Ý không chỉ có khả năng hút ẩm, mà còn cân bằng không khí và tiêu diệt các tế bào nấm mốc trong nhà nữa.", "1", 310000, 110000, new String[] {"day_nhen"}));
        products.add(new Product("5", "Cây dây nhện", "Cây dây nhện luôn có khả năng quang hợp dưới ánh sáng tối thiểu. Nó hấp thụ nhanh các chất độc từ không khí như Carbon monoxide, Formaldehyde, xăng và Styrene.", "Cây dây nhện luôn có khả năng quang hợp dưới ánh sáng tối thiểu. Nó hấp thụ nhanh các chất độc từ không khí như Carbon monoxide, Formaldehyde, xăng và Styrene. Ngoài ra, nó còn có thể chuyển hóa chất khí gây ung thưtrong không khí như Aldehyde formic thành đường và amoni acid. Một chậu cây nhỏ là đủ để làm sạch không khí trong không gian 200m2 đấy!", "2", 140000, 110000, new String[] {"duong_xi"}));
        products.add(new Product("6", "Cây nguyệt quế", "Nguyệt quế là loài cây bụi sống lâu năm, có mùi thơm, xuất xứ tại các quốc gia thuộc vùng Địa Trung Hải, thích hợp ở những vùng đất ẩm ướt có bóng râm.", "Nguyệt quế là loài cây bụi sống lâu năm, có mùi thơm, xuất xứ tại các quốc gia thuộc vùng Địa Trung Hải, thích hợp ở những vùng đất ẩm ướt có bóng râm. Từ lâu, người ta vẫn coi nguyệt quế hồng là biểu tượng của \"vinh quang và chiến thắng\". Có nguồn gốc từ vùng đất cận nhiệt đới nên loài cây này thích hợp không khí ẩm, bóng râm và nước ấm. Chúng hấp thụ độ ẩm trong không khí, tạo nên môi trường thoáng đãng.", "2", 155000, 110000, new String[] {"van_nien_thanh"}));
        products.add(new Product("7", "Cây cọ cảnh", "Cây cọ cảnh là một trong những loại cây thanh lọc không khí tốt nhất. Nó được xem như là một “bộ máy” lọc amoniac, vốn là thành phần chính trong chất tẩy rửa, dệt may và thuốc nhuộm, một cách hiệu quả.", "Cây cọ cảnh là một trong những loại cây thanh lọc không khí tốt nhất. Nó được xem như là một “bộ máy” lọc amoniac, vốn là thành phần chính trong chất tẩy rửa, dệt may và thuốc nhuộm, một cách hiệu quả. Cọ cảnh dễ trồng, sống được trong bóng râm thời gian dài, không cần chăm sóc bón phân cầu kì tỉ mỉ tuy nhiên nó lại hơi khó tạo dáng cho đẹp.", "2", 200000, 110000, new String[] {"lan_y"}));
        products.add(new Product("8", "Cây trầu bà", "Cây trầu bà vừa và nhỏ có thể để trên nóc tủ, trên bàn làm việc, treo cạnh cửa sổ để cành lá rủ xuống nhẹ nhàng.", "Cây trầu bà vừa và nhỏ có thể để trên nóc tủ, trên bàn làm việc, treo cạnh cửa sổ để cành lá rủ xuống nhẹ nhàng. Trầu bà là một trong những cây nội thất phổ biến nhất. Cây giúp làm sạch không khí trong nhà. Để cây cạnh các thiết bị điện tử sẽ hấp thụ các chất phóng xạ phát ra từ máy tính, TV, máy in,...", "2", 100000, 110000, new String[] {"luoi_ho"}));
        products.add(new Product("9", "Cây nha đam", "Cây nha đam được nhiều người biết đến với chức năng làm thực phẩm, thuốc chữa bệnh nhưng làm sạch không khí rất hiệu quả thì ít người biết đến.", "Cây nha đam được nhiều người biết đến với chức năng làm thực phẩm, thuốc chữa bệnh nhưng làm sạch không khí rất hiệu quả thì ít người biết đến. Đặc biệt nó còn có khả năng hiển thị lượng ô nhiễm trong không khí vượt quá mức cho phép qua những đốm nâu trên thân cây.", "3", 100000, 110000, new String[] {"nguyet_que"}));
        products.add(new Product("10", "Cây dương xỉ", "Cây dương xỉ được ví như một trong những máy lọc không khí hiệu quả nhất, cây hoạt động đặc biệt tốt trong việc loại bỏ formaldehyde.", "Cây dương xỉ được ví như một trong những máy lọc không khí hiệu quả nhất, cây hoạt động đặc biệt tốt trong việc loại bỏ formaldehyde. Một số nghiên cứu cũng cho thấy nó có thể loại bỏ kim loại độc hại như thủy ngân và asen.", "3", 100000, 110000, new String[] {"nha_dam"}));
        products.add(new Product("11", "Cây vạn niên thanh", "Cây vạn niên thanh sống lâu năm mà vẫn xanh tốt, vào mùa đông lá không héo úa nên được coi là loài cây cát tường vì thế được mọi người ưa chuộng và sử dụng rộng rãi.", "Cây vạn niên thanh sống lâu năm mà vẫn xanh tốt, vào mùa đông lá không héo úa nên được coi là loài cây cát tường vì thế được mọi người ưa chuộng và sử dụng rộng rãi. Không những thế cây còn giúp làm sạch formaldehyde trong bầu không khí và rất dễ trồng.", "3", 110000, 210000, new String[] {"trau_ba"}));
*/
        //semaphore.acquire();
        //return products;
    }

    public ArrayList<Category> getAllCategory() {
        final ArrayList<Category> categories = new ArrayList<>();
        final DatabaseReference myRefCate = database.getReference().child("Public-products");
        myRefCate.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dsp: dataSnapshot.getChildren()) {
                    String userKey = dsp.getKey();
                    String nameCat = dsp.child("name").getValue(String.class);
                    Log.d("TAG", nameCat);
                    categories.add(new Category(userKey, nameCat));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        /*categories.add(new Category("1", "Cây cảnh"));
        categories.add(new Category("2", "Cây phong thủy"));
        categories.add(new Category("3", "Cây trong nhà"));*/

        return categories;
    }

    public ArrayList<Product> getProductsByCategory(String idCategory) {
        ArrayList<Product> products = new ArrayList<>();
        /*
         * - Add product into array
         */

        return products;
    }

    public void getCart(final MyCallBack myCallBack) {
        final ArrayList<Cart> carts = new ArrayList<>();
        final List<String> idProduct = new ArrayList<>();
        final DatabaseReference myRefCart = database.getReference();
        String token = FirebaseInstanceId.getInstance().getToken();
        myRefCart.child("Cart").child(token).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (final DataSnapshot dps: dataSnapshot.getChildren()) {
                    idProduct.add(dps.getKey());
                    Log.d("TestID", idProduct.get(idProduct.size() - 1));
                    myRefCart.child("Public-products").child(dps.getValue(String.class)).child("products").child(dps.getKey()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String id = dps.getKey();
                            String name = dataSnapshot.child("name").getValue(String.class);
                            Integer price = dataSnapshot.child("price").getValue(int.class);
                            Integer sale = dataSnapshot.child("sale").getValue(int.class);
                            String[] image = new String[6];
                            int i = 0;
                            for (DataSnapshot dspImg: dataSnapshot.child("images").getChildren()) {
                                image[i++] = dspImg.getValue(String.class);
                            }
                            carts.add(new Cart(id, image[0], price - (price * sale / 100), name, 1));
                            myCallBack.onCallbackCart(carts);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                    myCallBack.onCallbackCart(carts);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
