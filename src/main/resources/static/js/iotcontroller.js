var vue=new Vue({
    el:"#app",
    data: {
        control:'',
        timewidth: '60%',
        watertimeselect:'',
        watertime:[
            1,
            2,
            3,
            4,
            5,
        ],
        infoser:'',
        self:this,
    },
    created: function () {

    },
    methods: {
       sendOp:function () {
           self=this;
           jQuery.getJSON("./test",function (data) {
               console.log(data);
               self.infoser=data.info;
           })
       },
        sendCon:function () {
           self=this;
            jQuery.getJSON("./sendpy/"+this.control,function (data) {
                console.log(data);
                self.infoser=data.info;
            })
        },
        getPicUrl:function () {
            self=this;
            jQuery.getJSON("./getpicture",function (data) {
                self.infoser=data.info;
            })
        },
        water:function () {
           self=this;
            jQuery.get("./sendpyop",{op : "water|"+self.watertimeselect},function (data) {
                self.infoser=data.info;
            })
        },
        takepic:function () {
            self=this;
            jQuery.getJSON("./sendpy/image"+this.control,function (data) {
                console.log(data);
                self.infoser=data.info;
            })
        }
    }
});