package kr.co.neoplus.studentlist_20210221.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CalendarView
import android.widget.TextView
import kr.co.neoplus.studentlist_20210221.R
import kr.co.neoplus.studentlist_20210221.datas.Student
import java.sql.RowId
import java.util.*
import kotlin.collections.ArrayList

class StudentAdapter(
    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<Student>) : ArrayAdapter<Student>(mContext, resId, mList) {

    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if (tempRow == null) {
            tempRow = inf.inflate(R.layout.student_list_item, null)
        }

        val row = tempRow!!

        val student = mList[position]

        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)
        val ageTxt = row.findViewById<TextView>(R.id.ageTxt)

        nameTxt.text = student.name
        ageTxt.text = "(${student.birthYear}세)"

        val cal = Calendar.getInstance()
        val age = cal.get(Calendar.YEAR) - student.birthYear + 1

        ageTxt.text = "(${age}세)"



        return row

    }
}