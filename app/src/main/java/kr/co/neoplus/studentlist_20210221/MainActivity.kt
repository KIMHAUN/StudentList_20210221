package kr.co.neoplus.studentlist_20210221

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kr.co.neoplus.studentlist_20210221.adapters.StudentAdapter
import kr.co.neoplus.studentlist_20210221.datas.Student

class MainActivity : AppCompatActivity() {

    val mStudentList = ArrayList<Student>()

    lateinit var mAdapter : StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mStudentList.add(Student("조경진", 1988))
        mStudentList.add(Student("강서영", 1990))
        mStudentList.add(Student("김윤경", 1981))
        mStudentList.add(Student("박은희", 1970))
        mStudentList.add(Student("신정범", 1989))
        mStudentList.add(Student("오이슬", 1994))
        mStudentList.add(Student("이예슬", 1990))
        mStudentList.add(Student("이지인", 1996))
        mStudentList.add(Student("채명호", 1973))
        mStudentList.add(Student("최원종", 1967))
        mStudentList.add(Student("최윤정", 1987))

        mAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)

        studentListView.adapter = mAdapter

        studentListView.setOnItemClickListener { parent, view, position, id ->

            val clickedStudent = mStudentList[position]
            Toast.makeText(this, clickedStudent.name, Toast.LENGTH_SHORT).show()

        }

        studentListView.setOnItemLongClickListener { parent, view, position, id ->

//            val std = mStudentList[position]
//            Toast.makeText(this, "${std.name} 길게 눌림", Toast.LENGTH_SHORT).show()

            val alert = AlertDialog.Builder(this)
            alert.setTitle("삭제 확인")
            alert.setMessage("정말 삭제하시겠습니까?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
                mStudentList.removeAt(position)
                mAdapter.notifyDataSetChanged()
            })
            alert.setNegativeButton("아니오", null)
            alert.show()

            return@setOnItemLongClickListener true

        }
    }
}