package com.example.doanapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String TEN_DATABASE= "ShoeStore";

    //Bang Product
    public static final String TEN_BANG_PRODUCTS = "Product";
    public static final String COT_ID_PRO = "_Id";
    public static final String COT_NAME_PRO = "_NamePro";
    public static final String COT_CATEGORY = "_Category";
    public static final String COT_BRAND_PRO = "_Brand";
    public static final String COT_DESCRIPTION_PRO = "_DescriptionPro";
    public static final String COT_PRICE = "_Price";
    public static final String COT_IMAGE_PRO = "_ImagePro";
    public static final String COT_SIZE_PRO = "_SizePro";
    public static final String COT_COLOR_PRO = "_ColorPro";



    //Bang Brand
    public static final String TEN_BANG_BRAND = "Brand";
    public  static  final String COT_ID_BRAND = "_IdBrand";
    public  static  final String COT_NAME_BRAND = "_NameBrand";
    public  static  final String COT_IMAGE_BRAND = "_ImageBrand";


    //Bang Caterogy
    public static final String TEN_BANG_CATEGORY = "Category";
    public  static  final String COT_ID_CATEGORY = "_IdCate";
    public  static  final String COT_NAME_CATEGORY = "_NameCate";


    //Bang Cart
    public static final String TEN_BANG_CART = "CartPro";
    public static final String COT_ID_CART = "_IdCart";
    public static final String COT_ID_Pro = "_IdPro";
    public static final String COT_ID_User = "_IdUser";
    public static final String COT_QUANTITY = "_Quantity";
    public static final String COT_COLOR_CART = "_ColorCart";
    public static final String COT_SIZE_CART = "_SizeCart";



    //Bang User
    public static final String TEN_BANG_USER = "User";
    public static final String COT_ID_USER = "_IdUser";
    public static final String COT_NAME_USER = "_Name";
    public static final String COT_EMAIL_USER = "_Email";
    public static final String COT_PASS_USER = "_Password";
    public static final String COT_PHONE_USER = "_Phone";
    public static final String COT_ADDRESS_USER = "_Address";
    public static final String COT_ROLE_USER = "_Role";


    //Bang Order
    public static final String TEN_BANG_ORDER = "OrderPro";
    public static final String COT_ID_ORDER = "_IdOrder";
    public static final String COT_DATE_ORDER = "_DateOder";
    public static final String COT_ID_Pro_Order = "_IdPro";
    public static final String COT_ID_User_Order = "_IdUser";
    public static final String COT_QUANTITY_Order = "_Quantity";
    public static final String COT_COLOR_Order = "_ColorOrder";
    public static final String COT_SIZE_Order = "_SizeOrder";
    public static final String COT_NAME_Order = "_NameOrder";
    public static final String COT_PHONE_Order = "_PhoneOrder";
    public static final String COT_ADDRESS_Order = "_AddressOrder";
    public static final String COT_STATUS_Order = "_StatusOrder";



    private static final String TAO_BANG_BRAND = ""
            + "CREATE TABLE " + TEN_BANG_BRAND + " ( "
            + COT_ID_BRAND + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COT_NAME_BRAND + " TEXT, "
            + COT_IMAGE_BRAND + " TEXT ) ";

    private static final String TAO_BANG_CATEGORY = ""
            + "CREATE TABLE " + TEN_BANG_CATEGORY + " ( "
            + COT_ID_CATEGORY + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COT_NAME_CATEGORY + "	TEXT ) ";


    private static final String TAO_BANG_CART = ""
            + "CREATE TABLE " + TEN_BANG_CART + " ( "
            + COT_ID_CART + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COT_ID_Pro + " INTEGER, "
            + COT_ID_User + " INTEGER, "
            + COT_QUANTITY + " INTEGER, "
            + COT_COLOR_CART + " TEXT, "
            + COT_SIZE_CART + " TEXT, "
            + "FOREIGN KEY(" + COT_ID_Pro + ") REFERENCES " + TEN_BANG_PRODUCTS + "(" + COT_ID_PRO + "), "
            + "FOREIGN KEY(" + COT_ID_User + ") REFERENCES " + TEN_BANG_USER + "(" + COT_ID_USER + ") ) ";


    private static final String TAO_BANG_USER = ""
            + "CREATE TABLE " + TEN_BANG_USER + " ( "
            + COT_ID_USER + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COT_NAME_USER + " TEXT, "
            + COT_EMAIL_USER + " TEXT, "
            + COT_PASS_USER + " TEXT, "
            + COT_PHONE_USER + " TEXT, "
            + COT_ADDRESS_USER + " TEXT, "
            + COT_ROLE_USER + " INTEGER ) ";


    private static final String TAO_BANG_PRODUCT = ""
            + "CREATE TABLE " + TEN_BANG_PRODUCTS + " ( "
            + COT_ID_PRO + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COT_NAME_PRO + " TEXT, "
            + COT_DESCRIPTION_PRO + " TEXT, "
            + COT_CATEGORY + " INTEGER, "
            + COT_BRAND_PRO + " INTEGER, "
            + COT_PRICE + " INTEGER, "
            + COT_IMAGE_PRO + " TEXT, "
            + COT_SIZE_PRO + " TEXT, "
            + COT_COLOR_PRO + " TEXT, "
            + "FOREIGN KEY(" + COT_BRAND_PRO + ") REFERENCES " + TEN_BANG_BRAND + "(" + COT_ID_BRAND + "), "
            + "FOREIGN KEY(" + COT_CATEGORY + ") REFERENCES " + TEN_BANG_CATEGORY + "(" + COT_ID_CATEGORY + ") ) ";


    private static final String TAO_BANG_ORDER = ""
            + "CREATE TABLE " + TEN_BANG_ORDER + " ( "
            + COT_ID_ORDER + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COT_ID_User_Order + " INTEGER, "
            + COT_ID_Pro_Order + " INTEGER, "
            + COT_QUANTITY_Order + " INTEGER, "
            + COT_DATE_ORDER + " TEXT, "
            + COT_COLOR_Order + " TEXT, "
            + COT_SIZE_Order + " TEXT, "
            + COT_NAME_Order + " TEXT, "
            + COT_PHONE_Order + " TEXT, "
            + COT_ADDRESS_Order + " TEXT, "
            + COT_STATUS_Order + " INTEGER, "
            + "FOREIGN KEY(" + COT_ID_Pro_Order + ") REFERENCES " + TEN_BANG_PRODUCTS + "(" + COT_ID_PRO + "), "
            + "FOREIGN KEY(" + COT_ID_User_Order + ") REFERENCES " + TEN_BANG_USER + "(" + COT_ID_USER + ") ) ";


    public DBHelper(Context context) {
        super(context, TEN_DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TAO_BANG_PRODUCT);
        sqLiteDatabase.execSQL(TAO_BANG_BRAND);
        sqLiteDatabase.execSQL(TAO_BANG_CATEGORY);
        sqLiteDatabase.execSQL(TAO_BANG_USER);
        sqLiteDatabase.execSQL(TAO_BANG_CART);
        sqLiteDatabase.execSQL(TAO_BANG_ORDER);

        THEM_DU_LIEU(sqLiteDatabase);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    private void THEM_DU_LIEU(SQLiteDatabase sqLiteDatabase)
    {

        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_CATEGORY + " (" + COT_NAME_CATEGORY + ") VALUES ('Thể thao');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_CATEGORY + " (" + COT_NAME_CATEGORY + ") VALUES ('Sneaker');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_CATEGORY + " (" + COT_NAME_CATEGORY + ") VALUES ('Running');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_CATEGORY + " (" + COT_NAME_CATEGORY + ") VALUES ('Bóng đá');");

        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_BRAND + " (" + COT_NAME_BRAND + "," + COT_IMAGE_BRAND + ") VALUES ('Nike', 'nike_logo.png');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_BRAND + " (" + COT_NAME_BRAND + "," + COT_IMAGE_BRAND + ") VALUES ('Adidas', 'adidas_logo.png');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_BRAND + " (" + COT_NAME_BRAND + "," + COT_IMAGE_BRAND + ") VALUES ('Mlb', 'mlb_logo.png');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_BRAND + " (" + COT_NAME_BRAND + "," + COT_IMAGE_BRAND + ") VALUES ('Puma', 'puma_logo.png');");


        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_USER + " (" + COT_NAME_USER + "," + COT_EMAIL_USER + "," + COT_PASS_USER + "," +  COT_ADDRESS_USER + "," + COT_PHONE_USER + "," + COT_ROLE_USER + ") VALUES ('Admin', 'admin@gmail.com', 'admin', null, null, 1);");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_USER + " (" + COT_NAME_USER + "," + COT_EMAIL_USER + "," + COT_PASS_USER + "," +  COT_ADDRESS_USER + "," + COT_PHONE_USER + "," + COT_ROLE_USER + ") VALUES ('Nhóm 5', 'nhom5@gmail.com', 'nhom5', 'SVH-Q10-TPHCM', '0123456789', null);");



        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Nike Airmax 270 React Youth', 1, 1, 2790000, 'nike_airmax1.jpg', '36 37 38 39 40 41 42 43 44', 'Vàng Trắng Đen'"
                + ",'Giày thể thao Nike Airmax 270 React Youth CT9633-100 với kiểu dáng trẻ trung, hiện đại đến từ thương hiệu Nike nổi tiếng của Mỹ. Đôi giày Nike Airmax 270 sẽ cho bạn trải nghiệm tuyệt vời nhất khi đi lên chân.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Nike Airmax 2 Light Habanero red', 1, 1, 2790000, 'nike_airmax_light1.jpg', '36 37 38 39 40 41 42 43 44', 'Đen Trắng Đỏ'"
                + ",'Giày thể thao Nike Air Max 2 Light Habanero Red được làm từ chất liệu da và vải cao cấp với độ ôm được thiết kế đặc biệt để nâng đỡ có định hướng và hỗ trợ chuyển động.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Adidas ZX 2K Boost Cloud', 1, 2, 2400000, 'adidas_boost_cloud1.jpg', '36 37 38 39 40 41 42 43 44', 'Trắng Đen'"
                + ",'Giày thể thao Adidas ZX 2K Boost Cloud White Solar Red Blue màu trắng là đôi giày dành cho nam đến từ thương hiệu Adidas nổi tiếng. Sở hữu gam màu nổi bật cùng chất liệu cao cấp Adidas ZX 2K Boost Cloud White Solar Red Blue sẽ cho bạn trải nghiệm tuyệt vời khi đi lên chân.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Adidas FW8077', 1, 2, 2280000, 'adidas_f_w1.png', '36 37 38 39 40 41 42 43 44', 'Vàng Trắng Đen'"
                + ",'Giày Thể Thao Adidas FW8077 Màu Trắng Size 41 là đôi giày dành cho nam đến từ thương hiệu Adidas nổi tiếng. Sở hữu gam màu nổi bật cùng chất liệu cao cấp Giày thể thao Adidas FW8077 sẽ cho bạn trải nghiệm tuyệt vời khi đi lên chân.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Puma Thunder Spectra Triple', 1, 4, 2770000, 'puma_thunder1.jpg', '36 37 38 39 40 41 42 43 44', 'Vàng Trắng Xanh'"
                + ",'Giày thể thao Puma Thunder Spectra Triple White 370682-01 size 38 mang gam màu trắng thanh lịch đến từ thương hiệu Puma nổi tiếng. Giày Puma Thunder Spectra Triple thích hợp cho nhiều hoạt động như chạy bộ, tập gym, chơi thể thao.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Puma RS-X Core', 1, 4, 2690000, 'puma_r_s_x1.jpg', '36 37 38 39 40 41 42 43 44', 'Xanh Trắng Đen'"
                + ",'Giày Puma RS-X Core Black với thiết kế form thể thao phóng đại, đi chắc chắn, êm ái, và vô cùng tiện lợi. Nắm được xu hướng chung, đánh vào tập khách hàng mê mẩn những item thời trang hiện đại, giày Puma RS-X Core Black ra đời đã đáp ứng được những mong mỏi của người yêu thời trang trên toàn thế giới.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('MLB Big Ball Chunky New York', 1, 3, 2890000, 'mlb_big_ball1.jpg', '36 37 38 39 40 41 42 43 44', 'Trắng Đen'"
                + ",'Giày MLB Big Ball Chunky New York Yankees 32SHCD111-50I là đôi giày thời trang dành cho cả nam và nữ đến từ thương hiệu MLB Hàn Quốc. Với gam màu thanh lịch cùng thiết kế hiện đại, đôi giày MLB Big Ball Chunky New York Yankees sẽ cho bạn trải nghiệm tuyệt vời khi đi lên chân.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('MLB Big Ball Chunky A Line New York', 1, 3, 2890000, 'mlb_big_ball_a_line1.jpg', '36 37 38 39 40 41 42 43 44', 'Vàng Trắng Đen'"
                + ",'Giày MLB Big Ball Chunky A Line New York Yankees 3ASHCLS2N-50BKS thuộc dòng giày unisex nổi tiếng của thương hiệu MLB Hàn Quốc. Với thiết kế tôn dáng, phối màu đẹp mắt, mầu giày MLB Big Ball Chunky A Line New York Yankees 3ASHCLS2N-50BKS được giới trẻ săn đón ngay từ khi mới mở bán.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Nike Air Jordan1', 2, 1, 5200000, 'nike_air_jordan1.jpg', '36 37 38 39 40 41 42 43 44', 'Xám Trắng'"
                + ",'Giày Thể Thao Nike Air Jordan 1 Low (GS) Màu Xám Trắng với thiết kế mang đậm tinh thần thể thao đến từ thương hiệu Nike nổi tiếng. Sở hữu phối màu thời thượng, chất liệu da cao cấp bền bỉ, mẫu giày Nike Air Jordan 1 Low (GS) . Giày thể thao Nike Air Jordan 1 Low (GS) được Nike sử dụng chất liệu da cao cấp, chống nước tốt và bền đẹp trong thời gian dài sử dụng.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Nike Air Force 1', 2, 1, 4000000, 'nike_air1.jpg', '36 37 38 39 40 41 42 43 44', 'Trắng Đen'"
                + ",'Giày Nike Air Force 1 ’07 White CW2288 111 có thiết kế đẹp mắt, kiểu dáng hiện đại. Với đôi giày thời trang này chắc chắn bạn sẽ trở nên nổi bật và cuốn hút hơn.Phần trên của giày Nike Air Force 1 ’07 White CW2288 111 màu trắng được làm từ chất liệu da cao cấp với độ ôm được thiết kế đặc biệt để nâng đỡ có định hướng và hỗ trợ chuyển động.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Puma Oslo-city Lux', 2, 4, 1990000, 'puma_oslo_city_lux1.jpg', '36 37 38 39 40 41 42 43 44', 'Trắng Đen'"
                + ",'Giày thể thao Puma Oslo-City Lux được làm từ chất liệu da cao cấp với độ ôm được thiết kế đặc biệt hỗ trợ chuyển động. Form giày Puma với các đường chỉ khâu vô cùng tỉ mỉ và chắc chắn. Nắm được xu thế chung của những khách hàng yêu thích phong cách thời trang hiện đại, đặc biệt là những thiết kế độc - lạ, giày thể thao Puma Oslo-City Lux ra đời đáp ứng được nhu cầu của những tín đồ thời trang trên toàn thế giới.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Puma Clyde Stitch', 2, 4, 1990000, 'puma_clyde_stitch1.jpg', '36 37 38 39 40 41 42 43 44', 'Vàng Trắng Đen'"
                + ",'Giày thể thao Puma Clyde Stitch được làm từ chất liệu da trơn cao cấp, bền đẹp trong suốt quá trình sử dụng. Lót giày Puma êm ái giúp bạn luôn cảm thấy thoải mái cho dù có đi giày cả ngày dài. Form giày Puma đi lên chân vừa vặn, các đường chỉ khâu vô cùng chắc chắn và tỉ mỉ hài lòng mọi khách hàng. Đôi giày với kiểu dáng Style trẻ trung, đẹp mắt, mang đậm phong cách, cá tính.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Adidas Stan Smith', 2, 2, 1750000, 'adidas_stan_smith1.jpg', '36 37 38 39 40 41 42 43 44', 'Xanh Trắng Đen'"
                + ",'Giày Adidas Originals Stan Smith Mens Shoes M20324 không phải là cái tên quá mới lạ trong trong danh sách giày thể thao sneaker nam đẹp. Giá giày Adidas Stan Smith M20324 luôn có mức giá phải chăng dễ mua nên việc các tín đồ giày sneaker và người yêu chạy bộ săn tìm cũng dễ dàng hơn.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Adidas Superstar', 2, 2, 1800000, 'adidas_supperstar1.jpg', '36 37 38 39 40 41 42 43 44', 'Vàng Trắng Đen'"
                + ",'Giày Adidas Superstar Originals AQ1214 trắng là giày cổ thấp với thiết kế mõm sò độc quyền của Adidas, phù hợp cho cả nam nữ, già trẻ, dễ dàng phối đồ và đang được nhiều tín đồ thời trang ưa chuộng. Giày Adidas Superstar Originals là một đôi giày nên có trong tủ đồ của bản bởi tính đa dụng và tiện lợi của nó.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('MLB Korea Low-Top', 2, 3, 1800000, 'mlb_korea_low_top1.jpg', '36 37 38 39 40 41 42 43 44', 'Vàng Xanh'"
                + ",'Giày thể thao MLB Korea Low-Top Sneakers được làm từ chất liệu vải dệt cao cấp với độ ôm hỗ trợ chuyển động. Đôi giày với thiết kế đơn giản đẹp mắt với tông màu trắng sang trọng. Họa tiết viền đỏ độc đáo, phá cách tạo điểm nhấn cho bạn phong cách trẻ trung, năng động.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('MLB Chunky Classic A New York YanKees', 2, 3, 1800000, 'mlb_chunky_classic1.jpg', '36 37 38 39 40 41 42 43 44', 'Vàng Trắng Đen'"
                + ",'Giày MLB Chunky Classic A New York Yankees 3ASXXA12N-50IVS thuộc một trong những dòng giày bán chạy nhất của thương hiệu Hàn Quốc MLB. Với gam màu trang nhã, thiết kế tôn dáng, mẫu giày MLB Chunky Classic A New York Yankees 3ASXXA12N-50IVS sẽ là điểm nhấn thú vị cho bộ trang phục của bạn.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Nike Phantom VSN Academy TF', 4, 1, 1880000, 'nike_phantom1.jpg', '36 37 38 39 40 41 42 43 44', 'Xanh Trắng Đen'"
                + ",'Giày bóng đá Nike Phantom Vsn Academy Df Tf Ao3269-080 với kiểu dáng trẻ trung, hiện đại đến từ thương hiệu Nike nổi tiếng của Mỹ. Đôi giày Nike Phantom Vsn Academy Df Tf Ao3269-080 sẽ cho bạn trải nghiệm tuyệt vời nhất khi đi lên chân. Ngay từ khi có mặt trên thị trường, đôi giày luôn được các chàng trai yêu thích bóng đá săn đón.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Nike Vapor 15 Academy TF', 4, 1, 2100000, 'nike_vapor1.jpg', '36 37 38 39 40 41 42 43 44', 'Trắng Đen'"
                + ",'Với phân khúc Academy, với hai mẫu Mercurial Superfly 9 và Vapor 15 Academy. Đây là phân khúc có giá thành khá hợp lý và phù hợp với điều kiện kinh tế của nhiều người chơi bóng bán chuyên và phong trào tại Việt Nam. Ở phiên bản Vapor 14 và Superfly 8 trước đó, phiên bản Academy của dòng Mercurial đã tạo nên cơn sốt rất lớn tại thị trường Việt Nam, với chất liệu mềm mại, cảm giác nhẹ nhàng và sự thật chân khi mang.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Adidas X Speedflow.1 Turf Shoes', 4, 2, 3220000, 'adidas_speedflow_turf1.png', '36 37 38 39 40 41 42 43 44', 'Vàng Trắng Đen'"
                + ",'Giày đá bóng Adidas X Speedflow.1 Turf Shoes GW7473 có thiết kế trẻ trung, năng động đến từ thương hiệu Adidas nổi tiếng của Đức. Giày được làm từ chất liệu cao cấp, bền đẹp nâng niu đôi chân trong suốt quá trình sử dụng.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Adidas Nemeziz.3 Turf', 4, 2, 1590000, 'adidas_nemeziz1.png', '36 37 38 39 40 41 42 43 44', 'Vàng Trắng Đen'"
                + ",'Giày bóng đá Adidas Nemeziz .3 Turf với kiểu dáng trẻ trung, hiện đại đến từ thương hiệu Adidas nổi tiếng của Đức. Đôi giày Adidas Nemeziz .3 Turf sẽ cho bạn trải nghiệm tuyệt vời nhất khi đi lên chân.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Puma Rapido II', 4, 4, 1450000, 'puma_rapido1.jpg', '36 37 38 39 40 41 42 43 44', 'Vàng Trắng Đen'"
                + ",'Giày bóng đá Puma Rapido II TT (106062-01) với phần thân giày được làm từ chất liệu da tổng hợp cao cấp. Form giày ôm chân hoàn hảo với các đường nét vô cùng tỉ mỉ và chắc chắn. Thiết kế siêu nhẹ và ôm chân cho bạn tư thế vững chãi. Đế ngoài bằng cao su thuôn gọn tăng cường đàn hồi trên mặt sân cỏ nhân tạo.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Puma Rapido II TF106062', 4, 4, 1650000, 'puma_rapido_ii1.jpg', '36 37 38 39 40 41 42 43 44', 'Vàng Trắng Đen'"
                + ",'Giày bóng đá Puma Rapido Ii Tf 106062 02 với phần thân giày được làm từ chất liệu da tổng hợp cao cấp. Form giày ôm chân hoàn hảo với các đường nét vô cùng tỉ mỉ và chắc chắn. Thiết kế siêu nhẹ và ôm chân cho bạn tư thế vững chãi.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Nike Odyssey React Womens Running Shoes', 3, 1, 1700000, 'nike_odyssey1.png', '36 37 38 39 40 41 42 43 44', 'Đỏ Đen'"
                + ",'Nike Odyssey React Women Running Shoes AO9820602 Size 36.5 là sản phẩm giày chạy dành cho nữ sử dụng công nghệ đệm React mới nhất của Nike, giày có trọng lượng nhẹ, tạo cảm giác êm ái khi vận động sẽ giúp bạn cảm thấy thoải mái. Nike Odyssey React Womens Running Shoes AO9820602 còn có khả năng hỗ trợ chuyển hướng linh hoạt và giảm nguy cơ chấn thương khi chạy.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Nike Zoom Winflo 6 Womens Shoes', 3, 1, 2200000, 'nike_zoom1.jpeg', '36 37 38 39 40 41 42 43 44', 'Vàng Trắng Đen'"
                + ",'Giày bóng đá Adidas Nemeziz .3 Turf với kiểu dáng trẻ trung, hiện đại đến từ thương hiệu Adidas nổi tiếng của Đức. Đôi giày Adidas Nemeziz .3 Turf sẽ cho bạn trải nghiệm tuyệt vời nhất khi đi lên chân.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Adidas Lite Racer 2.0', 3, 2, 1400000, 'adidas_lite1.png', '36 37 38 39 40 41 42 43 44', 'Xanh Trắng Đen'"
                + ",'Giày Chạy Bộ Nam Adidas Lite Racer 2.0 - FZ0392 là đôi giày dành cho nam đến từ thương hiệu Adidas nổi tiếng. Sở hữu gam màu thanh lịch cùng chất liệu cao cấp Giày Chạy Bộ Nam Adidas Lite Racer 2.0 - FZ0392 sẽ cho bạn trải nghiệm tuyệt vời cho bạn.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Adidas Ultraboost 21', 3, 2, 4000000, 'adidas_ultraboost1.jpg', '36 37 38 39 40 41 42 43 44', 'Trắng Đen'"
                + ",'Giày Chạy Bộ Nữ Adidas Ultraboost 21 W S23845 Phối Màu với phối màu lạ mắt đến từ thương hiệu Adidas nổi tiếng. Mẫu giày Adidas Ultraboost 21 W cùng chất liệu cao cấp, sẽ mang đến cho bạn trải nghiệm êm ái nhất khi lên chân.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Puma Scuderia Ferrari Speed Hybrid Running', 3, 4, 1980000, 'puma_scuderia1.jpg', '36 37 38 39 40 41 42 43 44', 'Trắng Đen'"
                + ",'Giày Puma Scuderia Ferrari Speed HYBRID Running 339847_01-380 Size 38 được thiết kế đặc biệt đáp ứng tốt sự êm ái, độ đàn hồi và phong cách thời trang độc đáo.');");
        sqLiteDatabase.execSQL("INSERT INTO " + TEN_BANG_PRODUCTS + " (" + COT_NAME_PRO + "," + COT_CATEGORY + "," + COT_BRAND_PRO + "," + COT_PRICE + "," + COT_IMAGE_PRO + "," + COT_SIZE_PRO + "," + COT_COLOR_PRO + "," + COT_DESCRIPTION_PRO
                + ") VALUES ('Puma Shoes Puma Turin II', 3, 4, 1880000, 'puma_turin1.jpg', '36 37 38 39 40 41 42 43 44', 'Trắng Đen'"
                + ",'Giày Thể Thao Puma Shoes Puma Turin II Jr 366773 02 Màu Trắng với thiết kế hiện đại đến từ thương hiệu nổi tiếng Puma. Sở hữu phối màu trắng basic dễ phối đồ, mẫu giày Puma Shoes Puma Turin II Jr 366773 02 sẽ là item mà các tín đồ mê sneaker đều nên sở hữu trong bộ sưu tập của mình.');");

    }
}
