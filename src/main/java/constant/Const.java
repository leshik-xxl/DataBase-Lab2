package constant;

public class Const {
    public static final String TICKET_TABLE = "ticket";
        public static final String TICKET_ID = "id_ticket";
        public static final String TICKET_CLIENT_ID = "fk_client_id";
        public static final String TICKET_PLACE_ID = "fk_id_place";
        public static final String TICKET_PRICE = "price";
        public static final String TICKET_BUY_DATE = "buy_date";
        public static final String TICKET_PRIVILEGE = "privilege";

    public static final String TRAIN_TABLE = "train";
        public static final String TRAIN_ID = "id_train";
        public static final String TRAIN_MAX_CARRIAGE = "max_carriage";

    public static final String ROUTE_TO_TRAIN_TABLE = "route_to_train";
        public static final String ROUTE_TO_TRAIN_ID = "id_route_to_train";
        public static final String ROUTE_TO_TRAIN_ROUTE_ID = "id_route";
        public static final String ROUTE_TO_TRAIN_TRAIN_ID = "id_train";
        public static final String ROUTE_TO_TRAIN_ARRIVE_TIME = "arrive_time";
        public static final String ROUTE_TO_TRAIN_DEPART_TIME = "depart_time";

    public static final String ROUTE_TABLE = "route";
        public static final String ROUTE_ID = "id_route";
        public static final String ROUTE_PLACE_OF_DEPARTURE = "place_of_departure";
        public static final String ROUTE_PLACE_OF_ARRIVAL = "place_of_arrival";

    public static final String PLACE_TABLE = "place";
        public static final String PLACE_ID = "id_place";
        public static final String PLACE_NUMBER = "number_place";
        public static final String PLACE_CARRIAGE_ID = "carriage_id";

    public static final String CLIENT_TABLE = "client";
        public static final String CLIENT_ID = "id_client";
        public static final String CLIENT_EMAIL = "e-mail";
        public static final String CLIENT_LOGIN = "login";
        public static final String CLIENT_FULL_NAME = "full_name";

    public static final String CARRIAGE_TABLE = "carriage";
        public static final String CARRIAGE_ID = "id_carriage";
        public static final String CARRIAGE_NUMBER = "number";
        public static final String CARRIAGE_TYPE = "type";
        public static final String CARRIAGE_ROUTE_TO_TRAIN_ID = "fk_id_route_to_train";

}
