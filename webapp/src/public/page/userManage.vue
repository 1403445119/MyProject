<template>
  <el-container>
  <el-header>员工管理：
  <el-form label-width="80px">
    <div style="float:right">
      <el-form-item>
         <el-input v-model="name" placeholder="请输入姓名" style="width:200px;"></el-input>
         <el-button @click="selectByName">查询</el-button>
      </el-form-item>
    </div>
  </el-form>
  </el-header>
  <el-main>
    <el-table header-align="center" :data="staffBean" border highlight-current-row>
      <el-table-column prop="staffId" label="编号" width="80"/>
      <el-table-column prop="staffName" label="姓名" width="100"/>
      <el-table-column prop="staffTel" label="联系电话" width="200"/>
      <el-table-column prop="staffPath" label="住址" width="300"/>
      <el-table-column prop="staffSalary" label="工资" width="120"/>
      <el-table-column prop="staffRemarks" label="备注" width="300"/>
      <el-table-column label="操作" fixed="right">
      <template slot-scope="scope">
        <el-button size="mini" @click="update(scope.row)">编辑</el-button>
        <el-button size="mini" type="danger" @click="delet(scope.row)">删除</el-button>
      </template>
    </el-table-column>
    </el-table>
  </el-main>
  <el-footer>
    <div class="block" style="position:absolute;left:50%;bottom:5%;">
        <el-pagination layout="prev, pager, next"  :page-size="page.pageSize" @current-change="pageChange"  :total="page.pageCount"></el-pagination>
    </div>
  </el-footer>
</el-container>

</template>
<script>
export default {
  data () {
    return {
      page:{
        pageCount:1,
        pageSize:10,
        pageNum:''
      },
      staffBean:[],
      name:'',
      upAndDel:{}
    }
  },
  methods: {
    async selectByName() {
        let rep = await this.$ajax.post('/staff_basic/select_by_name?name='+this.name,this.page)
        this.staffBean = rep.data.data.list
        this.page={
          pageCount: rep.data.data.total,
          pageSize: rep.data.data.pageSize,
          pageNum: rep.data.data.pageNum
        }
    },
    async pageChange(val) {
      this.page.pageNum = val
      let rep = await this.$ajax.post('/staff_basic/select_by_name?name='+this.name,this.page)
      this.staffBean = rep.data.data.list
      this.page={
        pageCount: rep.data.data.total,
        pageSize: rep.data.data.pageSize,
        pageNum: rep.data.data.pageNum
      }
    },
    update(row) {
       console.log(row);
    },
    delet(row) {
       console.log(row);
    }
  },
  async created() {
    let rep = await this.$ajax.post('/staff_basic/select_all',this.page)
    this.staffBean = rep.data.data.list
    this.page={
      pageCount: rep.data.data.total,
      pageSize: rep.data.data.pageSize,
      pageNum: rep.data.data.pageNum
    }
    console.log(this.page)
   }
 }
</script>
